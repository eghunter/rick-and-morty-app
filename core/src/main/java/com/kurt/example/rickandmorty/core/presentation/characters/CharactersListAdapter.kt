package com.kurt.example.rickandmorty.core.presentation.characters

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kurt.example.rickandmorty.core.R
import com.kurt.example.rickandmorty.core.domain.entities.Character
import com.kurt.example.rickandmorty.core.presentation.utils.navigateUriWithDefaultOptions
import com.marvel.example.core.presentation.BaseListAdapter

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/05/2019
 */
class CharactersListAdapter : BaseListAdapter<Character>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {
    override val itemLayout = R.layout.list_item_character

    override fun bindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = getItem(position)

        holder.itemView.apply {
            val imgCharacter by lazy { findViewById<ImageView>(R.id.img_character) }
            val txtName by lazy { findViewById<TextView>(R.id.txt_name) }

            Glide.with(context)
                .load(character.image)
                .into(imgCharacter)

            txtName.text = character.name

            setOnClickListener {
                ViewCompat.setTransitionName(imgCharacter, "imgCharacter")
                ViewCompat.setTransitionName(txtName, "txtName")
                val extras = FragmentNavigatorExtras(
                    imgCharacter to imgCharacter.transitionName,
                    txtName to txtName.transitionName
                )
                findNavController().navigateUriWithDefaultOptions(
                    Uri.parse("rickandmorty://characterdetails/${character.id}/${character.image.replace("/", "\\")}/${character.name}"),
                    extras
                )
            }
        }
    }
}