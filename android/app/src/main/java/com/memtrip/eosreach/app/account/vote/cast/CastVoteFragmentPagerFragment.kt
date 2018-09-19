package com.memtrip.eosreach.app.account.vote.cast

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.memtrip.eosreach.R
import com.memtrip.eosreach.api.account.EosAccount
import com.memtrip.eosreach.app.account.vote.cast.CastVoteFragmentPagerFragment.Page.*

import com.memtrip.eosreach.app.account.vote.cast.producers.CastProducersVoteFragment
import com.memtrip.eosreach.app.account.vote.cast.proxy.CastProxyVoteFragment
import java.util.Arrays

class CastVoteFragmentPagerFragment(
    fragmentManager: FragmentManager,
    private val context: Context,
    private val eosAccount: EosAccount,
    private val pages: List<Page> = Arrays.asList(PRODUCER, PROXY),
    private val producerFragment: CastProducersVoteFragment = CastProducersVoteFragment.newInstance(eosAccount),
    private val proxyFragment: CastProxyVoteFragment = CastProxyVoteFragment.newInstance(eosAccount)
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        val page = pages[position]
        return when (page) {
            PRODUCER -> context.getString(R.string.vote_cast_page_block_producers_tab)
            PROXY -> context.getString(R.string.vote_cast_page_proxy_tab)
        }
    }

    override fun getItem(position: Int): Fragment {
        val page = pages[position]
        return when (page) {
            PRODUCER -> producerFragment
            PROXY -> proxyFragment
        }
    }

    override fun getCount(): Int = pages.size

    enum class Page {
        PRODUCER,
        PROXY
    }
}