package com.daniela.medstracker.ui.pages.meds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniela.medstracker.data.dao.MedicationDao
import com.daniela.medstracker.data.entities.Medication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MedsViewModel (
    private val medicationDao: MedicationDao
) : ViewModel() {

    private val _medications = MutableStateFlow<List<Medication>>(emptyList())
    val medications: StateFlow<List<Medication>> = _medications.asStateFlow()

    init {
        viewModelScope.launch {
            medicationDao.getAllMedications().collect { medsList ->
                _medications.value = medsList
            }
        }
    }
}