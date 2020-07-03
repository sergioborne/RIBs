package com.badoo.ribs.example.root

import com.badoo.ribs.clienthelper.connector.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.customisation.RibCustomisation
import com.badoo.ribs.example.auth.AuthStateStorage
import com.badoo.ribs.example.login.AuthCodeDataSource
import com.badoo.ribs.example.network.UnsplashApi
import com.badoo.ribs.example.root.Root.Input
import com.badoo.ribs.example.root.Root.Output
import com.badoo.ribs.example.root.routing.RootRouter
import com.badoo.ribs.portal.CanProvidePortal
import com.badoo.ribs.routing.transition.handler.TransitionHandler

interface Root : Rib, Connectable<Input, Output> {

    interface Dependency: CanProvidePortal {
        val api: UnsplashApi
        val authStateStorage: AuthStateStorage
        val authCodeDataSource: AuthCodeDataSource
    }

    sealed class Input

    sealed class Output

    class Customisation(
        val transitionHandler: TransitionHandler<RootRouter.Configuration>? = null
    ) : RibCustomisation
}
