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
import org.jgrasstools.modules.Wateroutlet; 
 
@Algorithm(version = "1.0.0", abstrakt = "Extract the watershed for a defined outlet (ported from GRASS r.wateroutlet).")
public class WateroutletAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(WateroutletAlgorithm.class); 

  public WateroutletAlgorithm() { 
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
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The map of flowdirections.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
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
    logger.info("org.jgrasstools.wps.n52.WateroutletAlgorithm");
    
    Wateroutlet tmpModule = new Wateroutlet(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pNorth",  (double) pnorth); 
    logger.info("pNorth " + ( (double) pnorth) );
    inputs.put("pEast",  (double) peast); 
    logger.info("pEast " + ( (double) peast) );
    inputs.put("outBasin",  (String) outbasin); 
    logger.info("outBasin " + ( (String) outbasin) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    
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
    outputs.put("outBasin", "String"); 
    
    res_outbasin = (String) outbasin; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outArea")) { 
            // and put them into the output result variables 
            res_outarea = (double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outBasin")) { 
            // and put them into the output result variables 
            res_outbasin = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

