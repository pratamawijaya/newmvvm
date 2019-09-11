package newmvvm.feature.opendota.presentation.list.holder

import com.github.ajalt.timberkt.d
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_heroes.view.*
import newmvvm.common.extensions.loadFromUrl
import newmvvm.feature.opendota.R
import newmvvm.feature.opendota.domain.model.Heroes

class HeroesItem(private val hero: Heroes) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val imgHeroes = viewHolder.itemView.imgHeroes
        val tvTitleHeroes = viewHolder.itemView.titleHeroes

        d { "heroes ${hero.name} ${hero.img}" }
        imgHeroes.loadFromUrl(hero.img)
        tvTitleHeroes.text = hero.name
    }

    override fun getLayout(): Int = R.layout.item_heroes

}