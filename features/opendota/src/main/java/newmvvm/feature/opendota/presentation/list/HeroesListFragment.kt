package newmvvm.feature.opendota.presentation.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_heroes_list.*
import newmvvm.feature.opendota.R
import newmvvm.feature.opendota.presentation.list.holder.HeroesItem
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class HeroesListFragment : Fragment() {

    private val heroesVm: HeroesListViewModel by inject()
    private val heroesAdapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heroes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heroesVm.heroesListState.observe(this, stateObserver)
        heroesVm.getHeroes()


        rvListHeroes.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = heroesAdapter
        }
    }

    private val stateObserver = Observer<HeroesListState> { state ->
        when (state) {
            is HeroesLoaded -> {
                state.heroes.map {
                    heroesAdapter.add(HeroesItem(it))
                }
            }
        }
    }
}