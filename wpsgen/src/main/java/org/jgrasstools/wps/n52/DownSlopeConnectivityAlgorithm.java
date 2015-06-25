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
import org.jgrasstools.modules.DownSlopeConnectivity; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for the calculation of the downslope connectivity.")
public class DownSlopeConnectivityAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(DownSlopeConnectivityAlgorithm.class); 

  public DownSlopeConnectivityAlgorithm() { 
    super();
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
  private String innet;

  @LiteralDataInput(identifier = "inNet", abstrakt = "The network map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNet(String innet) { 
    this.innet = innet;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = m/m
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The map of slope.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inweights;

  @LiteralDataInput(identifier = "inWeights", abstrakt = "The optional map of weights.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinWeights(String inweights) { 
    this.inweights = inweights;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pweight;

  @LiteralDataInput(identifier = "pWeight", abstrakt = "The optional constant value of weights.", minOccurs = 0, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpWeight(Double pweight) { 
    this.pweight = pweight;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outconnectivity;

  @LiteralDataInput(identifier = "outConnectivity", abstrakt = "The connectivity map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutConnectivity(String outconnectivity) { 
    this.outconnectivity = outconnectivity;
  }

  private String res_outconnectivity;

  @LiteralDataOutput(identifier = "res_outConnectivity", abstrakt = "The connectivity map.", binding = LiteralStringBinding.class)
  public String getRes_outConnectivity() { 
    return res_outconnectivity;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.DownSlopeConnectivityAlgorithm");
    
    DownSlopeConnectivity tmpModule = new DownSlopeConnectivity(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outConnectivity",  (String) outconnectivity); 
    logger.info("outConnectivity " + ( (String) outconnectivity) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("inNet",  (String) innet); 
    logger.info("inNet " + ( (String) innet) );
    inputs.put("pWeight",  (Double) pweight); 
    logger.info("pWeight " + ( (Double) pweight) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("inWeights",  (String) inweights); 
    logger.info("inWeights " + ( (String) inweights) );
    
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
    
    outputs.put("outConnectivity", "String"); 
    
    res_outconnectivity = (String) outconnectivity; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outConnectivity")) { 
            // and put them into the output result variables 
            res_outconnectivity = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

