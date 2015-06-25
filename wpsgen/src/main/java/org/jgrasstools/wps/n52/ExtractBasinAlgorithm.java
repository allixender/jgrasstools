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
import org.jgrasstools.modules.ExtractBasin; 
 
@Algorithm(version = "1.0.0", abstrakt = "Extract a basin from a map of flowdirections.")
public class ExtractBasinAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(ExtractBasinAlgorithm.class); 

  public ExtractBasinAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = northing
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pnorth;

  @LiteralDataInput(identifier = "pNorth", abstrakt = "The northern coordinate of the watershed outlet.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpNorth(double pnorth) { 
    this.pnorth = pnorth;
  }

    // inputOutputIndicator = input
    // fileIndicator = easting
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double peast;

  @LiteralDataInput(identifier = "pEast", abstrakt = "The eastern coordinate of the watershed outlet.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpEast(double peast) { 
    this.peast = peast;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pvalue;

  @LiteralDataInput(identifier = "pValue", abstrakt = "The value for the map (defaults to 1).", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpValue(double pvalue) { 
    this.pvalue = pvalue;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The map of flowdirections.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innetwork;

  @LiteralDataInput(identifier = "inNetwork", abstrakt = "A user supplied network map. If available, the outlet point is snapped to it before extracting the basin.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNetwork(String innetwork) { 
    this.innetwork = innetwork;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double psnapbuffer;

  @LiteralDataInput(identifier = "pSnapbuffer", abstrakt = "A buffer to consider for network snapping.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSnapbuffer(double psnapbuffer) { 
    this.psnapbuffer = psnapbuffer;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dovector;

  @LiteralDataInput(identifier = "doVector", abstrakt = "Flag to enable vector basin extraction.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoVector(Boolean dovector) { 
    this.dovector = dovector;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dosmoothing;

  @LiteralDataInput(identifier = "doSmoothing", abstrakt = "Flag to enable vector basin smoothing.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoSmoothing(Boolean dosmoothing) { 
    this.dosmoothing = dosmoothing;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outbasin;

  @LiteralDataInput(identifier = "outBasin", abstrakt = "The extracted basin mask.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutBasin(String outbasin) { 
    this.outbasin = outbasin;
  }

  private String res_outbasin;

  @LiteralDataOutput(identifier = "res_outBasin", abstrakt = "The extracted basin mask.", binding = LiteralStringBinding.class)
  public String getRes_outBasin() { 
    return res_outbasin;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outoutlet;

  @LiteralDataInput(identifier = "outOutlet", abstrakt = "The optional outlet point vector map.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutOutlet(String outoutlet) { 
    this.outoutlet = outoutlet;
  }

  private String res_outoutlet;

  @LiteralDataOutput(identifier = "res_outOutlet", abstrakt = "The optional outlet point vector map.", binding = LiteralStringBinding.class)
  public String getRes_outOutlet() { 
    return res_outoutlet;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outvectorbasin;

  @LiteralDataInput(identifier = "outVectorBasin", abstrakt = "The optional extracted basin vector map.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutVectorBasin(String outvectorbasin) { 
    this.outvectorbasin = outvectorbasin;
  }

  private String res_outvectorbasin;

  @LiteralDataOutput(identifier = "res_outVectorBasin", abstrakt = "The optional extracted basin vector map.", binding = LiteralStringBinding.class)
  public String getRes_outVectorBasin() { 
    return res_outvectorbasin;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double res_outarea;

  @LiteralDataOutput(identifier = "res_outArea", abstrakt = "The area of the extracted basin.", binding = LiteralDoubleBinding.class)
  public double getRes_outArea() { 
    return res_outarea;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.ExtractBasinAlgorithm");
    
    ExtractBasin tmpModule = new ExtractBasin(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pNorth",  (double) pnorth); 
    logger.info("pNorth " + ( (double) pnorth) );
    inputs.put("pSnapbuffer",  (double) psnapbuffer); 
    logger.info("pSnapbuffer " + ( (double) psnapbuffer) );
    inputs.put("pValue",  (double) pvalue); 
    logger.info("pValue " + ( (double) pvalue) );
    inputs.put("outOutlet",  (String) outoutlet); 
    logger.info("outOutlet " + ( (String) outoutlet) );
    inputs.put("doVector",  (Boolean) dovector); 
    logger.info("doVector " + ( (Boolean) dovector) );
    inputs.put("doSmoothing",  (Boolean) dosmoothing); 
    logger.info("doSmoothing " + ( (Boolean) dosmoothing) );
    inputs.put("pEast",  (double) peast); 
    logger.info("pEast " + ( (double) peast) );
    inputs.put("outBasin",  (String) outbasin); 
    logger.info("outBasin " + ( (String) outbasin) );
    inputs.put("inNetwork",  (String) innetwork); 
    logger.info("inNetwork " + ( (String) innetwork) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("outVectorBasin",  (String) outvectorbasin); 
    logger.info("outVectorBasin " + ( (String) outvectorbasin) );
    
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
    
    outputs.put("outArea", "double"); 
    outputs.put("outOutlet", "String"); 
    outputs.put("outBasin", "String"); 
    outputs.put("outVectorBasin", "String"); 
    
    res_outoutlet = (String) outoutlet; 
    res_outbasin = (String) outbasin; 
    res_outvectorbasin = (String) outvectorbasin; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outArea")) { 
            // and put them into the output result variables 
            res_outarea = (double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outOutlet")) { 
            // and put them into the output result variables 
            res_outoutlet = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outBasin")) { 
            // and put them into the output result variables 
            res_outbasin = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outVectorBasin")) { 
            // and put them into the output result variables 
            res_outvectorbasin = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

