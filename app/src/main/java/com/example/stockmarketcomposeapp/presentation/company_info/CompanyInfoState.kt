package com.example.stockmarketcomposeapp.presentation.company_info

import com.example.stockmarketcomposeapp.domain.model.CompanyInfo
import com.example.stockmarketcomposeapp.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
