package com.memtrip.eosreach.api.stub

import com.memtrip.eosreach.api.StubApi
import okhttp3.Request
import okhttp3.Response

class StubConnection(
    private val request: Request,
    vararg stubApi: StubApi
) {

    private val stubs: List<Stub> = stubApi.flatMap { it.stubs() }

    fun performRequest(): Response {
        return match(request)
    }

    private fun match(request: Request): Response {
        return stubs
            .first { it.matcher.urlMatcher.containsMatchIn(request.url().toString()) }
            .stubRequest
            .call(request)
    }
}