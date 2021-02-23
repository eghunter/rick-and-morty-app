package sfg.kmm.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import sfg.kmm.api.data.characters.CharactersRemoteSourceImpl
import sfg.kmm.api.data.characters.CharactersRepositoryImpl
import sfg.kmm.api.domain.usecase.GetAllCharacters
import sfg.kmm.api.network.KmmHttpClient
import sfg.kmm.api.network.Request
import sfg.kmm.api.remote.CharactersApi

class NativeViewModel(
    private val viewUpdate: (List<String>) -> Unit
) {

    private val scope = MainScope()
    private val getAllCharacters: GetAllCharacters = GetAllCharacters(
        CharactersRepositoryImpl(
            CharactersRemoteSourceImpl(
                CharactersApi(
                    Request(
                        KmmHttpClient.defaultClient("rickandmortyapi.com/api")
                    )
                )
            )
        )
    )

    fun getAllCharacters() {
        scope.launch {
            flowOf(
                getAllCharacters.invoke(0)
                    .map { it.name }
            ).collect { viewUpdate(it) }
        }
    }
}
