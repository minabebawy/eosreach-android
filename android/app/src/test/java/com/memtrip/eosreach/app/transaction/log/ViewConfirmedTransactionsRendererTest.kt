package com.memtrip.eosreach.app.transaction.log

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class ViewConfirmedTransactionsRendererTest : Spek({

    val layout by memoized { mock<ViewConfirmedTransactionsViewLayout>() }

    given("a ViewConfirmedTransactionsRenderer") {

        val renderer by memoized { ViewConfirmedTransactionsViewRenderer() }

        on("ViewState is not initialized") {
            renderer.layout(layout, ViewConfirmedTransactionsViewState(ViewConfirmedTransactionsViewState.View.OnProgress))

            it("shows the Progress") {
                verify(layout).showProgress()
            }
        }

        on("ViewState is initialized") {
            renderer.layout(layout, ViewConfirmedTransactionsViewState(ViewConfirmedTransactionsViewState.View.OnError))

            it("hides the Progress") {
                verify(layout).showError()
            }
        }
    }
})
