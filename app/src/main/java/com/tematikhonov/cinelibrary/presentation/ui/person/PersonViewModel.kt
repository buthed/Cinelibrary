package com.tematikhonov.cinelibrary.presentation.ui.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematikhonov.cinelibrary.domain.models.entites.Person
import com.tematikhonov.cinelibrary.domain.repositories.person.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class PersonViewModel  @Inject constructor(private val repository: PersonRepository): ViewModel() {

    var personId by Delegates.notNull<Int>()

    private val _person = MutableLiveData<Person>()
    val person: LiveData<Person>
        get() =_person

    private suspend fun fetchPerson(personId: Int) = flow {
        emit(repository.getPerson(personId))
    }

    private fun getPerson(personId: Int) {
        viewModelScope.launch {
            fetchPerson(personId).collect{
                _person.postValue(it)
            }
        }
    }

    fun init(personId: Int){
        this.personId = personId
        getPerson(personId)
    }
}