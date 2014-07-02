package uqbar.android.planificadorhorarios.horarios.services;

import com.google.gson.*;
import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

import java.lang.reflect.Type;
import java.util.Date;

public class PlanificadorService extends RetrofitGsonSpiceService {
    private final static String BASE_URL = "http://192.168.150.1:9000";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(Planificador.class);
    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }

    @Override
    protected Converter createConverter() {
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        return new GsonConverter(builder.create());
    }
}