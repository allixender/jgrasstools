/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */
package org.jgrasstools.wps.n52; 
 
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
import org.jgrasstools.modules.RasterTransformer; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for raster tranforms.")
public class RasterTransformerAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(RasterTransformerAlgorithm.class); 

  public RasterTransformerAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster;

  @LiteralDataInput(identifier = "inRaster", abstrakt = "The raster that has to be transformed.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster(String inraster) { 
    this.inraster = inraster;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo:nearest neightbour,bilinear,bicubic
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pinterpolation;

  @LiteralDataInput(identifier = "pInterpolation", abstrakt = "The interpolation type to use", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpInterpolation(String pinterpolation) { 
    this.pinterpolation = pinterpolation;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    // uom = m
  private Double ptransx;

  @LiteralDataInput(identifier = "pTransX", abstrakt = "The translation along the X axis.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpTransX(Double ptransx) { 
    this.ptransx = ptransx;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    // uom = m
  private Double ptransy;

  @LiteralDataInput(identifier = "pTransY", abstrakt = "The translation along the Y axis.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpTransY(Double ptransy) { 
    this.ptransy = ptransy;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pscalex;

  @LiteralDataInput(identifier = "pScaleX", abstrakt = "The scale factor along X axis.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpScaleX(Double pscalex) { 
    this.pscalex = pscalex;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pscaley;

  @LiteralDataInput(identifier = "pScaleY", abstrakt = "The scale factor along the Y axis.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpScaleY(Double pscaley) { 
    this.pscaley = pscaley;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dofliphorizontal;

  @LiteralDataInput(identifier = "doFlipHorizontal", abstrakt = "Flip horizontally.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoFlipHorizontal(Boolean dofliphorizontal) { 
    this.dofliphorizontal = dofliphorizontal;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doflipvertical;

  @LiteralDataInput(identifier = "doFlipVertical", abstrakt = "Flip vertically.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoFlipVertical(Boolean doflipvertical) { 
    this.doflipvertical = doflipvertical;
  }

    // inputOutputIndicator = input
    // fileIndicator = northing
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pnorth;

  @LiteralDataInput(identifier = "pNorth", abstrakt = "The northern coordinate of the rotation point.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpNorth(Double pnorth) { 
    this.pnorth = pnorth;
  }

    // inputOutputIndicator = input
    // fileIndicator = easting
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double peast;

  @LiteralDataInput(identifier = "pEast", abstrakt = "The eastern coordinate of the rotation point.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpEast(Double peast) { 
    this.peast = peast;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    // uom = degrees
  private Double pangle;

  @LiteralDataInput(identifier = "pAngle", abstrakt = "The rotation angle in degree (rotation is performed before translation).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpAngle(Double pangle) { 
    this.pangle = pangle;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outraster;

  @LiteralDataInput(identifier = "outRaster", abstrakt = "The transformed raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutRaster(String outraster) { 
    this.outraster = outraster;
  }

  private String res_outraster;

  @LiteralDataOutput(identifier = "res_outRaster", abstrakt = "The transformed raster.", binding = LiteralStringBinding.class)
  public String getRes_outRaster() { 
    return res_outraster;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outbounds;

  @LiteralDataInput(identifier = "outBounds", abstrakt = "The new raster geometry.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutBounds(String outbounds) { 
    this.outbounds = outbounds;
  }

  private String res_outbounds;

  @LiteralDataOutput(identifier = "res_outBounds", abstrakt = "The new raster geometry.", binding = LiteralStringBinding.class)
  public String getRes_outBounds() { 
    return res_outbounds;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.RasterTransformerAlgorithm");
    
    RasterTransformer tmpModule = new RasterTransformer(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pNorth",  (Double) pnorth); 
    logger.info("pNorth " + ( (Double) pnorth) );
    inputs.put("pScaleX",  (Double) pscalex); 
    logger.info("pScaleX " + ( (Double) pscalex) );
    inputs.put("pTransY",  (Double) ptransy); 
    logger.info("pTransY " + ( (Double) ptransy) );
    inputs.put("outRaster",  (String) outraster); 
    logger.info("outRaster " + ( (String) outraster) );
    inputs.put("pAngle",  (Double) pangle); 
    logger.info("pAngle " + ( (Double) pangle) );
    inputs.put("pScaleY",  (Double) pscaley); 
    logger.info("pScaleY " + ( (Double) pscaley) );
    inputs.put("pTransX",  (Double) ptransx); 
    logger.info("pTransX " + ( (Double) ptransx) );
    inputs.put("pInterpolation",  (String) pinterpolation); 
    logger.info("pInterpolation " + ( (String) pinterpolation) );
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("doFlipHorizontal",  (Boolean) dofliphorizontal); 
    logger.info("doFlipHorizontal " + ( (Boolean) dofliphorizontal) );
    inputs.put("pEast",  (Double) peast); 
    logger.info("pEast " + ( (Double) peast) );
    inputs.put("doFlipVertical",  (Boolean) doflipvertical); 
    logger.info("doFlipVertical " + ( (Boolean) doflipvertical) );
    inputs.put("outBounds",  (String) outbounds); 
    logger.info("outBounds " + ( (String) outbounds) );
    
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.setInputData(inputs, tmpModule, uLog); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
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
    outputs.put("outBounds", "String"); 
    
    res_outraster = (String) outraster; 
    res_outbounds = (String) outbounds; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outRaster")) { 
            // and put them into the output result variables 
            res_outraster = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outBounds")) { 
            // and put them into the output result variables 
            res_outbounds = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

