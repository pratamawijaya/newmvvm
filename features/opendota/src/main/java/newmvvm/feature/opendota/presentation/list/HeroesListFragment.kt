package newmvvm.feature.opendota.presentation.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import newmvvm.feature.opendota.R
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class HeroesListFragment : Fragment() {

    private val heroesVm: HeroesListViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heroes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        heroesVm.getHeroes()
    }


}
