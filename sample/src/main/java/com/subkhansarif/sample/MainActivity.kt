package com.subkhansarif.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.subkhansarif.bottomnavbar.BottomMenu
import com.subkhansarif.bottomnavbar.IBottomClickListener
import com.subkhansarif.sample.fragments.FoodFragment
import com.subkhansarif.sample.fragments.PetFragment
import com.subkhansarif.sample.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IBottomClickListener {

    private var menu: MutableList<BottomMenu> = ArrayList()

    companion object {
        const val MENU_PERSON = 0L
        const val MENU_PETS = 1L
        const val MENU_RESTAURANT = 2L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavbar()
    }

    private fun setupBottomNavbar() {
        // create menu
        menu.add(BottomMenu(MENU_PERSON, ProfileFragment(), getString(R.string.lbl_menu_profile), R.drawable.ic_person_grey, "a_cup_of_coffee.json"))
        menu.add(BottomMenu(MENU_PETS, PetFragment(), getString(R.string.lbl_menu_pet), R.drawable.ic_pets_grey, "a_cup_of_coffee.json"))
        menu.add(BottomMenu(MENU_RESTAURANT, FoodFragment(), getString(R.string.lbl_menu_Food), R.drawable.ic_restaurant_menu_grey, null) {
            Toast.makeText(this, "Coming soon!", Toast.LENGTH_SHORT).show()
            // return true to override button click
            true
        })

        bottom_navbar.setFragmentManager(supportFragmentManager)
        bottom_navbar.setMenu(menu)
        bottom_navbar.setSelected(1)
        bottom_navbar.setNavbarPositionTop()
        bottom_navbar.setMenuClickListener(this)
    }

    override fun menuClicked(position: Int, id: Long) {
    }
}