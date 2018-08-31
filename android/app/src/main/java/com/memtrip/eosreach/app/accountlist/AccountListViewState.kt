package com.memtrip.eosreach.app.accountlist

import com.memtrip.eosreach.db.AccountEntity
import com.memtrip.mxandroid.MxViewState

data class AccountListViewState(val view: View) : MxViewState {

    sealed class View {
        object Idle : View()
        object OnProgress : View()
        data class OnSuccess(val accountList: List<AccountEntity>) : View()
        object OnError : View()
        data class NavigateToAccount(val accountEntity: AccountEntity) : View()
    }
}