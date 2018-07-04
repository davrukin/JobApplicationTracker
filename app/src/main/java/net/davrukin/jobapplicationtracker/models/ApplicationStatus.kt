package net.davrukin.jobapplicationtracker.models

enum class ApplicationStatus(var stage: Int) {
    APPLIED(0),
    INITIAL_NO(0),
    INVITATION_TO_PHONE_SCREEN(0),
    CODING_CHALLENGE(0),
    ON_SITE_INTERVIEW(0),
    OFFER(0)
}

