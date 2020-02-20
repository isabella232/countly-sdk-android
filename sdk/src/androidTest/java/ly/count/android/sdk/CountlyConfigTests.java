package ly.count.android.sdk;

import android.app.Activity;
import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static androidx.test.InstrumentationRegistry.getContext;
import static org.mockito.Mockito.mock;

@RunWith(AndroidJUnit4.class)
public class CountlyConfigTests {

    @Before
    public void setUp(){
        Countly.sharedInstance().setLoggingEnabled(true);
    }

    @Test
    public void constructor(){
        CountlyConfig config = new CountlyConfig(getContext(), "Som345345", "fsdf7349374");

        assertDefaultValues(config, false);
    }

    @Test
    public void settingAllValues() {
        String[] s = new String[]{"4234234234ff", "sssa2323", "sds", "sdfsdf232", "aa22", "xvcx", "hghn", "0gifg", "kfkfdd"};
        Context c = getContext();
        CountlyConfig config = new CountlyConfig();
        CountlyStore cs = new CountlyStore(c);

        CountlyStarRating.RatingCallback rc = new CountlyStarRating.RatingCallback() {
            @Override
            public void onRate(int rating) {

            }

            @Override
            public void onDismiss() {

            }
        };

        RemoteConfig.RemoteConfigCallback rcc = new RemoteConfig.RemoteConfigCallback() {
            @Override
            public void callback(String error) {

            }
        };

        Map<String, String> hv = new HashMap<>();
        hv.put("11", "22");
        hv.put("1331", "2332");

        String[] fn = new String[]{"ds dsd", "434f", "ngfhg"};

        Pattern[] rf = new Pattern[]{Pattern.compile("d dsd"), Pattern.compile("454gf")};

        Map<String, Object> vs = new HashMap<>();
        vs.put("ss", "fdf");
        vs.put("s22s", 2323);
        vs.put("s44s", 33434.33d);

        Class[] act = new Class[]{Activity.class};


        assertDefaultValues(config, true);


        config.setServerURL(s[0]);
        config.setContext(c);
        config.setAppKey(s[1]);
        config.setCountlyStore(cs);
        config.checkForNativeCrashDumps(false);
        config.setDeviceId(s[2]);
        config.setIdMode(DeviceId.Type.ADVERTISING_ID);
        config.setStarRatingLimit(1335);
        config.setStarRatingCallback(rc);
        config.setStarRatingTextDismiss(s[3]);
        config.setStarRatingTextMessage(s[4]);
        config.setStarRatingTextTitle(s[5]);
        config.setLoggingEnabled(true);
        config.enableCrashReporting();
        config.setViewTracking(true);
        config.setAutoTrackingUseShortName(true);
        config.addCustomNetworkRequestHeaders(hv);
        config.setPushIntentAddMetadata(true);
        config.setRemoteConfigAutomaticDownload(true, rcc);
        config.setRequiresConsent(true);
        config.setConsentEnabled(fn);
        config.setHttpPostForced(true);
        config.enableTemporaryDeviceIdMode();
        config.setCrashFilters(rf);
        config.setParameterTamperingProtectionSalt(s[6]);
        config.setAutomaticViewSegmentation(vs);
        config.setAutoTrackingExceptions(act);
        config.setTrackOrientationChanges(true);
        config.setEventQueueSizeToSend(1337);
        config.setRecordAllThreadsWithCrash();


        Assert.assertEquals(s[0], config.serverURL);
        Assert.assertEquals(c, config.context);
        Assert.assertEquals(s[1], config.appKey);
        Assert.assertEquals(cs, config.countlyStore);
        Assert.assertEquals(false, config.checkForNativeCrashDumps);
        Assert.assertEquals(s[2], config.deviceID);
        Assert.assertEquals(DeviceId.Type.ADVERTISING_ID, config.idMode);
        Assert.assertEquals(1335, config.starRatingLimit);
        Assert.assertEquals(rc, config.starRatingCallback);
        Assert.assertEquals(s[3], config.starRatingTextDismiss);
        Assert.assertEquals(s[4], config.starRatingTextMessage);
        Assert.assertEquals(s[5], config.starRatingTextTitle);
        Assert.assertEquals(true, config.loggingEnabled);
        Assert.assertEquals(true, config.enableUnhandledCrashReporting);
        Assert.assertEquals(true, config.enableViewTracking);
        Assert.assertEquals(true, config.autoTrackingUseShortName);
        Assert.assertEquals(hv, config.customNetworkRequestHeaders);
        Assert.assertEquals(true, config.pushIntentAddMetadata);
        Assert.assertEquals(true, config.enableRemoteConfigAutomaticDownload);
        Assert.assertEquals(rcc, config.remoteConfigCallback);
        Assert.assertEquals(true, config.shouldRequireConsent);
        Assert.assertEquals(fn, config.enabledFeatureNames);
        Assert.assertEquals(true, config.httpPostForced);
        Assert.assertEquals(true, config.temporaryDeviceIdEnabled);
        Assert.assertEquals(rf, config.crashRegexFilters);
        Assert.assertEquals(s[6], config.tamperingProtectionSalt);
        Assert.assertEquals(vs, config.automaticViewSegmentation);
        Assert.assertEquals(act, config.autoTrackingExceptions);
        Assert.assertTrue(config.trackOrientationChange);
        Assert.assertEquals(1337, config.eventQueueSizeThreshold.intValue());
        Assert.assertTrue(config.recordAllThreadsWithCrash);
    }

    @Test
    public void defaultValues(){
        CountlyConfig config = new CountlyConfig();

        assertDefaultValues(config, true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void autoTrackingExceptionNull() {
        CountlyConfig config = new CountlyConfig();
        config.setAutoTrackingExceptions(new Class[]{null});
    }

    void assertDefaultValues(CountlyConfig config, boolean includeConstructorValues){
        if(includeConstructorValues){
            Assert.assertEquals(null, config.context);
            Assert.assertEquals(null, config.serverURL);
            Assert.assertEquals(null, config.appKey);
        }

        Assert.assertEquals(null, config.countlyStore);
        Assert.assertEquals(true, config.checkForNativeCrashDumps);
        Assert.assertEquals(null, config.deviceID);
        Assert.assertEquals(null, config.idMode);
        Assert.assertEquals(5, config.starRatingLimit);
        Assert.assertEquals(null, config.starRatingCallback);
        Assert.assertEquals(null, config.starRatingTextDismiss);
        Assert.assertEquals(null, config.starRatingTextMessage);
        Assert.assertEquals(null, config.starRatingTextTitle);
        Assert.assertEquals(false, config.loggingEnabled);
        Assert.assertEquals(false, config.enableUnhandledCrashReporting);
        Assert.assertEquals(false, config.enableViewTracking);
        Assert.assertEquals(false, config.autoTrackingUseShortName);
        Assert.assertEquals(null, config.customNetworkRequestHeaders);
        Assert.assertEquals(false, config.pushIntentAddMetadata);
        Assert.assertEquals(false, config.enableRemoteConfigAutomaticDownload);
        Assert.assertEquals(null, config.remoteConfigCallback);
        Assert.assertEquals(false, config.shouldRequireConsent);
        Assert.assertEquals(null, config.enabledFeatureNames);
        Assert.assertEquals(false, config.httpPostForced);
        Assert.assertEquals(false, config.temporaryDeviceIdEnabled);
        Assert.assertEquals(null, config.crashRegexFilters);
        Assert.assertEquals(null, config.tamperingProtectionSalt);
        Assert.assertEquals(null, config.automaticViewSegmentation);
        Assert.assertEquals(null, config.eventQueueSizeThreshold);
        Assert.assertEquals(false, config.trackOrientationChange);
        Assert.assertNull(config.eventQueueSizeThreshold);
        Assert.assertFalse(config.recordAllThreadsWithCrash);
    }
}
