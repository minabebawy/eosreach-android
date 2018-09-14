package com.memtrip.eosreach.app.account.resources.manage.manageram.form

import android.app.Application
import com.memtrip.eosreach.app.account.resources.manage.bandwidth.BandwidthFormViewModel
import com.memtrip.eosreach.app.account.resources.manage.manageram.RamFormViewModel
import javax.inject.Inject

class SellRamFormViewModel @Inject internal constructor(
    application: Application
): RamFormViewModel(application)