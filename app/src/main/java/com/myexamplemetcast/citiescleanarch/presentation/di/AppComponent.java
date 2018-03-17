package com.myexamplemetcast.citiescleanarch.presentation.di;


import com.myexamplemetcast.citiescleanarch.data.network.ApiFactory;
import com.myexamplemetcast.citiescleanarch.data.repository.TownsDataRepository;
import com.myexamplemetcast.citiescleanarch.presentation.di.modules.DatabaseModule;
import com.myexamplemetcast.citiescleanarch.presentation.di.modules.NetInspectorModule;
import com.myexamplemetcast.citiescleanarch.presentation.di.modules.ServiceModule;
import com.myexamplemetcast.citiescleanarch.presentation.ui.MainActivity;
import javax.inject.Singleton;
import dagger.Component;


@Singleton
@Component(modules = {
        ServiceModule.class,
        DatabaseModule.class,
        NetInspectorModule.class

})

 public interface AppComponent {

     void injectMainActivity(MainActivity activity);
   void injectTownsDataRepository(TownsDataRepository townsDataRepository);
     void injectApiFactory(ApiFactory apiFactory);
   //  void injectCitiesCacheTransformer(CitiesCacheTransformer citiesCacheTransformer);

}
