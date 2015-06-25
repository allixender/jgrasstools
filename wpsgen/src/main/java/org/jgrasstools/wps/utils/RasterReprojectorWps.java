package org.jgrasstools.wps.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import oms3.Access;
import oms3.ComponentAccess;
import oms3.annotations.Execute;
import oms3.annotations.Finalize;
import oms3.annotations.Initialize;

import org.geotools.process.ProcessException;
import org.jgrasstools.modules.RasterReprojector;

/**
 * Created by akmoch on 23/06/15.
 */
public class RasterReprojectorWps {

    public static int RasterReprojectorBuilder(
            HashMap<String, HashMap<String, Object>> conf,
            HashMap<String, HashMap<String, Object>> inputs,
            HashMap<String, HashMap<String, Object>> outputs) {

        Logger gLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Logger logger = Logger.getLogger(RasterReprojectorWps.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Info Log " + RasterReprojectorWps.class.getCanonicalName());

        try {
            // LogManager.getLogManager().readConfiguration(
            //  new FileInputStream("/www/includes/zoo-cgi-bin/logging.properties"));

            RasterReprojector tmpModule = new RasterReprojector();

            Map<String, Object> omsInputs = new HashMap<String, Object>();

            for (String hashElem : inputs.keySet()) {
                logger.info("input map element: " + hashElem);
                logger.info("input map type: " + inputs.get(hashElem).get("value").getClass().getCanonicalName());
                if (inputs.get(hashElem).get("value") instanceof String) {
                    String valueElement = (String) inputs.get(hashElem).get("value");
                    omsInputs.put(hashElem, valueElement);
                } else {
                    logger.warning("something weird here, input map element: " + hashElem);
                }
            }

            // set the inputs to the model, setInputData(Map<String,Object>, Object, Logger)
            ComponentAccess.setInputData(omsInputs, tmpModule, gLogger);

            // trigger execution of the module
            ComponentAccess.callAnnotated(tmpModule, Initialize.class, true);
            ComponentAccess.callAnnotated(tmpModule, Execute.class, false);
            ComponentAccess.callAnnotated(tmpModule, Finalize.class, true);

            // get the results
            ComponentAccess cA = new ComponentAccess(tmpModule);
            Collection<Access> outputsCollection = cA.outputs();

            // and put them into the output map
            for (Access access : outputsCollection) {
                try {
                    HashMap<String, Object> outputMap = new HashMap<String, Object>();
                    String fieldName = access.getField().getName();
                    Object fieldValue = access.getFieldValue();
                    outputMap.put("value", fieldValue);
                    outputs.put(fieldName, outputMap);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new ProcessException(e.getLocalizedMessage());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.warning(e.getLocalizedMessage());

            HashMap<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("value", new String("ERROR: " + e.getLocalizedMessage()));
            outputs.put("result", resultMap);

            return 4;
        }
        return 3;
    }
}
