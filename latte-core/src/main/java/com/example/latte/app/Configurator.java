package com.example.latte.app;

import java.util.WeakHashMap;

/**
 * Created by Jsoner on 2017/7/23.
 */

public class Configurator {
    private static final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }
    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }
    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    final WeakHashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }
    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }
    private void cheakConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not Ready , call configure");
        }
    }
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        cheakConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }

}
