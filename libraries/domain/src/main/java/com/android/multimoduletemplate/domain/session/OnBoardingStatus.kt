package com.android.multimoduletemplate.domain.session

enum class OnBoardingStatus(status: Int) {
    NOT_STARTED(0),
    STARTED(1),
    PARTIALLY_COMPLETED(2),
    COMPLETED(3),
}

enum class RegStatus(status: Int) {
    NEW(0),
    OLD(1),
}