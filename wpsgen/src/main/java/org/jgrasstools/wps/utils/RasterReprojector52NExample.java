package org.jgrasstools.wps.utils;

import java.util.Collection;
import java.util.HashMap;

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

import org.jgrasstools.modules.RasterReprojector;


@Algorithm(version = "1.0.0", abstrakt = "Module for raster reprojection.")
public class RasterReprojector52NExample extends AbstractAnnotatedAlgorithm {

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    private String inRaster;

    // inputOutputIndicator = input
    // fileIndicator = process_north
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    private Double pnorth;

    // inputOutputIndicator = input
    // fileIndicator = process_south
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    private Double psouth;

    // inputOutputIndicator = input
    // fileIndicator = process_west
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    private Double pwest;

    // inputOutputIndicator = input
    // fileIndicator = process_east
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    private Double peast;

    // inputOutputIndicator = input
    // fileIndicator = process_rows
    // fieldType = Integer
    // fieldBindingType = Int
    // fieldVariableType = Integer
    private Integer prows;

    // inputOutputIndicator = input
    // fileIndicator = process_cols
    // fieldType = Integer
    // fieldBindingType = Int
    // fieldVariableType = Integer
    private Integer pcols;

    // inputOutputIndicator = input
    // fileIndicator = combo:nearest neightbour,bilinear,bicubic
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    private String pinterpolation;

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    private String outRaster;

    // inputOutputIndicator = input
    // fileIndicator = crs
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    private String pcode;

    private String resOutRaster;

    static final Logger logger = LoggerFactory.getLogger(RasterReprojector52NExample.class);

    public RasterReprojector52NExample() {
        super();
    }

    @LiteralDataInput(identifier = "inRaster", abstrakt = "The raster that has to be reprojected.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
    public void setInRaster(String inRaster) {
        this.inRaster = inRaster;
    }

    @LiteralDataInput(identifier = "pNorth", abstrakt = "The north bound of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
    public void setpNorth(Double pnorth) {
        this.pnorth = pnorth;
    }

    @LiteralDataInput(identifier = "pSouth", abstrakt = "The south bound of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
    public void setpSouth(Double psouth) {
        this.psouth = psouth;
    }

    @LiteralDataInput(identifier = "pWest", abstrakt = "The west bound of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
    public void setpWest(Double pwest) {
        this.pwest = pwest;
    }

    @LiteralDataInput(identifier = "pEast", abstrakt = "The east bound of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
    public void setpEast(Double peast) {
        this.peast = peast;
    }

    @LiteralDataInput(identifier = "pRows", abstrakt = "The rows of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
    public void setpRows(Integer prows) {
        this.prows = prows;
    }

    @LiteralDataInput(identifier = "pCols", abstrakt = "The cols of the region to consider", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
    public void setpCols(Integer pcols) {
        this.pcols = pcols;
    }

    @LiteralDataInput(identifier = "pCode", abstrakt = "The code defining the target coordinate reference system, composed by authority and code number (ex. EPSG:4328).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
    public void setpCode(String pcode) {
        this.pcode = pcode;
    }

    @LiteralDataInput(identifier = "pInterpolation", abstrakt = "The interpolation type to use", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
    public void setpInterpolation(String pinterpolation) {
        this.pinterpolation = pinterpolation;
    }

    @LiteralDataInput(identifier = "outRaster", abstrakt = "The reprojected output raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
    public void setOutRaster(String outRaster) {

        this.outRaster = outRaster;
    }

    @LiteralDataOutput(identifier = "resOutRaster", abstrakt = "The reprojected output raster.", binding = LiteralStringBinding.class)
    public String getResOutRaster() {

        return resOutRaster;
    }

    @org.n52.wps.algorithm.annotation.Execute
    public void runAlgorithm() throws Exception {
        logger.info("org.jgrasstools.wps.n52.RasterReprojector52NExample");

        RasterReprojector tmpModule = new RasterReprojector();

        // set the inputs to the model
        HashMap<String, Object> inputs = new HashMap<String, Object>();
        inputs.put("pNorth", (Double) pnorth);
        logger.info("pNorth " + ((Double) pnorth));
        inputs.put("outRaster", (String) outRaster);
        logger.info("outRaster " + ((String) outRaster));
        inputs.put("pInterpolation", (String) pinterpolation);
        logger.info("pInterpolation " + ((String) pinterpolation));
        inputs.put("inRaster", (String) inRaster);
        logger.info("inRaster " + ((String) inRaster));
        inputs.put("pSouth", (Double) psouth);
        logger.info("pSouth " + ((Double) psouth));
        inputs.put("pEast", (Double) peast);
        logger.info("pEast " + ((Double) peast));
        inputs.put("pRows", (Integer) prows);
        logger.info("pRows " + ((Integer) prows));
        inputs.put("pCode", (String) pcode);
        logger.info("pCode " + ((String) pcode));
        inputs.put("pCols", (Integer) pcols);
        logger.info("pCols " + ((Integer) pcols));
        inputs.put("pWest", (Double) pwest);
        logger.info("pWest " + ((Double) pwest));
        try {
            java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojector52NExample.class.getName());
            ComponentAccess.setInputData(inputs, tmpModule, uLog);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // trigger execution of the module
        try {
            ComponentAccess.callAnnotated(tmpModule, Initialize.class, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            ComponentAccess.callAnnotated(tmpModule, Execute.class, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            ComponentAccess.callAnnotated(tmpModule, Finalize.class, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // get the results
        HashMap<String, String> outputs = new HashMap<String, String>();
        ComponentAccess cA = new ComponentAccess(tmpModule);
        Collection<Access> outputsCollection = cA.outputs();

        outputs.put("outRaster", "String");

        resOutRaster = outRaster;

        for (Access access : outputsCollection) {
            String fieldName = access.getField().getName();
            logger.info("access.getField().getName() = " + fieldName);
            Object fieldValue = access.getFieldValue();

            if (fieldName.equalsIgnoreCase("outRaster")) {
                // and put them into the output result variables
                resOutRaster = (String) access.getFieldValue();
            }
        }

    }

}

