plugins {
    //trick: for the same plugin versions in all sub-modules
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.android.application) apply(false)
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.android.library) apply(false)
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.android) apply(false)
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.multiplatform) apply(false)
}