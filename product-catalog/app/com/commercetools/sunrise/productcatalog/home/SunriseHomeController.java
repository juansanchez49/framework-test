package com.commercetools.sunrise.productcatalog.home;

import com.commercetools.sunrise.framework.template.engine.ContentRenderer;
import com.commercetools.sunrise.framework.viewmodels.content.PageContent;
import com.commercetools.sunrise.framework.controllers.SunriseContentController;
import com.commercetools.sunrise.framework.controllers.WithQueryFlow;
import com.commercetools.sunrise.framework.hooks.EnableHooks;
import com.commercetools.sunrise.framework.reverserouters.SunriseRoute;
import com.commercetools.sunrise.framework.reverserouters.productcatalog.home.HomeReverseRouter;
import com.commercetools.sunrise.productcatalog.home.viewmodels.HomePageContentFactory;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

/**
 * Controller for the home page.
 */
public abstract class SunriseHomeController extends SunriseContentController implements WithQueryFlow<Void> {

    private final HomePageContentFactory homePageContentFactory;

    protected SunriseHomeController(final ContentRenderer contentRenderer,
                                    final HomePageContentFactory homePageContentFactory) {
        super(contentRenderer);
        this.homePageContentFactory = homePageContentFactory;
    }

    @EnableHooks
    @SunriseRoute(HomeReverseRouter.HOME_PAGE)
    public CompletionStage<Result> show(final String languageTag) {
        return showPage(null);
    }

    @Override
    public PageContent createPageContent(final Void input) {
        return homePageContentFactory.create(null);
    }
}
