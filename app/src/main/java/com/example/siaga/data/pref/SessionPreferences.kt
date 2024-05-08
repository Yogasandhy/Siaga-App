//package com.example.siaga.data.pref
//
//class SessionPreferences private constructor(private val dataStore: DataStore) {
//    companion object {
//        @Volatile
//        private var instance: SessionPreferences? = null
//
//        fun getInstance(dataStore: DataStore): SessionPreferences =
//            instance ?: synchronized(this) {
//                instance ?: SessionPreferences(dataStore)
//            }
//    }
//
//    fun saveSession(sessionModel: SessionModel) {
//        dataStore.saveSession(sessionModel)
//    }
//
//    fun getSession(): SessionModel {
//        return dataStore.getSession()
//    }
//
//    fun clearSession() {
//        dataStore.clearSession()
//    }
//}