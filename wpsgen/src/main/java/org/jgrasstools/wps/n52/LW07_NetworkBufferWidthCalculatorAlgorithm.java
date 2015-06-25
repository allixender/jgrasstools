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
import org.jgrasstools.modules.LW07_NetworkBufferWidthCalculator; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculate the inundation zones along the channel network following a power law for the new width based on the original widht and the channel slope.")
public class LW07_NetworkBufferWidthCalculatorAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LW07_NetworkBufferWidthCalculatorAlgorithm.class); 

  public LW07_NetworkBufferWidthCalculatorAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innetpoints;

  @LiteralDataInput(identifier = "inNetPoints", abstrakt = "The input hierarchy point network layer with the information of local slope.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNetPoints(String innetpoints) { 
    this.innetpoints = innetpoints;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ingeo;

  @LiteralDataInput(identifier = "inGeo", abstrakt = "The input polygon layer with the geological superficial geological formations.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinGeo(String ingeo) { 
    this.ingeo = ingeo;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String insectwidth;

  @LiteralDataInput(identifier = "inSectWidth", abstrakt = "The input line shapefile with the extracted transversal sections.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSectWidth(String insectwidth) { 
    this.insectwidth = insectwidth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pprepostcount4slope;

  @LiteralDataInput(identifier = "pPrePostCount4Slope", abstrakt = "The number of cells upstream and downstream to consider to evaluate the average slope in each section.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpPrePostCount4Slope(int pprepostcount4slope) { 
    this.pprepostcount4slope = pprepostcount4slope;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pk;

  @LiteralDataInput(identifier = "pK", abstrakt = "Formula constant of the power law for the evaluation of the new width: newWidth = width + k * slope^n", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpK(double pk) { 
    this.pk = pk;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pn;

  @LiteralDataInput(identifier = "pN", abstrakt = "Formula exponent of the power law for the evaluation of the new width: newWidth = width + k * slope^n", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpN(double pn) { 
    this.pn = pn;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dokeepbridgedamwidth;

  @LiteralDataInput(identifier = "doKeepBridgeDamWidth", abstrakt = "The boolean to select if considering the width of dams and bridges or not.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoKeepBridgeDamWidth(Boolean dokeepbridgedamwidth) { 
    this.dokeepbridgedamwidth = dokeepbridgedamwidth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pminslope;

  @LiteralDataInput(identifier = "pMinSlope", abstrakt = "The value to use for the places where the slope is zero in the input raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpMinSlope(double pminslope) { 
    this.pminslope = pminslope;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnetpoints;

  @LiteralDataInput(identifier = "outNetPoints", abstrakt = "The output points network layer with the additional attribute of inundated width and average slope.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNetPoints(String outnetpoints) { 
    this.outnetpoints = outnetpoints;
  }

  private String res_outnetpoints;

  @LiteralDataOutput(identifier = "res_outNetPoints", abstrakt = "The output points network layer with the additional attribute of inundated width and average slope.", binding = LiteralStringBinding.class)
  public String getRes_outNetPoints() { 
    return res_outnetpoints;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outinundationarea;

  @LiteralDataInput(identifier = "outInundationArea", abstrakt = "The output polygon layer with the inundation areas.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutInundationArea(String outinundationarea) { 
    this.outinundationarea = outinundationarea;
  }

  private String res_outinundationarea;

  @LiteralDataOutput(identifier = "res_outInundationArea", abstrakt = "The output polygon layer with the inundation areas.", binding = LiteralStringBinding.class)
  public String getRes_outInundationArea() { 
    return res_outinundationarea;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outinundationsections;

  @LiteralDataInput(identifier = "outInundationSections", abstrakt = "The output layer with the sections lines where the inundation width has been calculated.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutInundationSections(String outinundationsections) { 
    this.outinundationsections = outinundationsections;
  }

  private String res_outinundationsections;

  @LiteralDataOutput(identifier = "res_outInundationSections", abstrakt = "The output layer with the sections lines where the inundation width has been calculated.", binding = LiteralStringBinding.class)
  public String getRes_outInundationSections() { 
    return res_outinundationsections;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LW07_NetworkBufferWidthCalculatorAlgorithm");
    
    LW07_NetworkBufferWidthCalculator tmpModule = new LW07_NetworkBufferWidthCalculator(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inNetPoints",  (String) innetpoints); 
    logger.info("inNetPoints " + ( (String) innetpoints) );
    inputs.put("inGeo",  (String) ingeo); 
    logger.info("inGeo " + ( (String) ingeo) );
    inputs.put("doKeepBridgeDamWidth",  (Boolean) dokeepbridgedamwidth); 
    logger.info("doKeepBridgeDamWidth " + ( (Boolean) dokeepbridgedamwidth) );
    inputs.put("outInundationArea",  (String) outinundationarea); 
    logger.info("outInundationArea " + ( (String) outinundationarea) );
    inputs.put("pN",  (double) pn); 
    logger.info("pN " + ( (double) pn) );
    inputs.put("inSectWidth",  (String) insectwidth); 
    logger.info("inSectWidth " + ( (String) insectwidth) );
    inputs.put("outNetPoints",  (String) outnetpoints); 
    logger.info("outNetPoints " + ( (String) outnetpoints) );
    inputs.put("pMinSlope",  (double) pminslope); 
    logger.info("pMinSlope " + ( (double) pminslope) );
    inputs.put("pK",  (double) pk); 
    logger.info("pK " + ( (double) pk) );
    inputs.put("outInundationSections",  (String) outinundationsections); 
    logger.info("outInundationSections " + ( (String) outinundationsections) );
    inputs.put("pPrePostCount4Slope",  (int) pprepostcount4slope); 
    logger.info("pPrePostCount4Slope " + ( (int) pprepostcount4slope) );
    
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
    
    outputs.put("outInundationArea", "String"); 
    outputs.put("outNetPoints", "String"); 
    outputs.put("outInundationSections", "String"); 
    
    res_outinundationarea = (String) outinundationarea; 
    res_outnetpoints = (String) outnetpoints; 
    res_outinundationsections = (String) outinundationsections; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outInundationArea")) { 
            // and put them into the output result variables 
            res_outinundationarea = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outNetPoints")) { 
            // and put them into the output result variables 
            res_outnetpoints = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outInundationSections")) { 
            // and put them into the output result variables 
            res_outinundationsections = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

