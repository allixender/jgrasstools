/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */
package org.jgrasstools.wps.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import oms3.Access;
import oms3.ComponentAccess;
import oms3.annotations.Execute;
import oms3.annotations.Finalize;
import oms3.annotations.Initialize;

import org.n52.wps.server.AbstractAnnotatedAlgorithm;
import org.n52.wps.algorithm.annotation.*;

import org.n52.wps.io.data.binding.literal.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.geotools.process.ProcessException;
import org.jgrasstools.modules.Ab;

@Algorithm(version = "1.0.0", abstrakt = "Calculates the draining area per length unit.")
public class AbExampleN52Algorithm extends AbstractAnnotatedAlgorithm {

    static final Logger logger = LoggerFactory.getLogger(AbExampleN52Algorithm.class);

    public AbExampleN52Algorithm() {
        super();
    }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    private String intca;

    @LiteralDataInput(identifier = "inTca", abstrakt = "The map of the total contributing area.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
    public void setinTca(String intca) {
        this.intca = intca;
    }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    private String inplan;

    @LiteralDataInput(identifier = "inPlan", abstrakt = "The map of the planar curvatures.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
    public void setinPlan(String inplan) {
        this.inplan = inplan;
    }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    private String outab;

    @LiteralDataOutput(identifier = "outAb", abstrakt = "The map of area per length.", binding = LiteralStringBinding.class)
    public String getoutAb() {
        return outab;
    }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    private String outb;

    @LiteralDataOutput(identifier = "outB", abstrakt = "The map of contour line.", binding = LiteralStringBinding.class)
    public String getoutB() {
        return outb;
    }

    @org.n52.wps.algorithm.annotation.Execute
    public void runAlgorithm() throws Exception {
        logger.info("org.jgrasstools.wps.n52.AbAlgorithm");

        Ab tmpModule = new Ab();

        // set the inputs to the model
        HashMap<String, Object> inputs = new HashMap<String, Object>();
        HashMap<String, String> outputs = new HashMap<String, String>();
        ComponentAccess.setInputData(inputs, tmpModule, null);

        // trigger execution of the module
        ComponentAccess.callAnnotated(tmpModule, Initialize.class, true);
        ComponentAccess.callAnnotated(tmpModule, Execute.class, false);
        ComponentAccess.callAnnotated(tmpModule, Finalize.class, true);

        // get the results
        ComponentAccess cA = new ComponentAccess(tmpModule);
        Collection<Access> outputsCollection = cA.outputs();

        outputs.put("outB", "String");
        outputs.put("outAb", "String");

        for( Access access : outputsCollection ) {
            String fieldName = access.getField().getName();
            Object fieldValue = access.getFieldValue();

            if (fieldName.equalsIgnoreCase("outB")) {
                // and put them into the output result variables
                outb = (String) access.getFieldValue();
            }
            if (fieldName.equalsIgnoreCase("outAb")) {
                // and put them into the output result variables
                outab = (String) access.getFieldValue();
            }
        }

    }

}

