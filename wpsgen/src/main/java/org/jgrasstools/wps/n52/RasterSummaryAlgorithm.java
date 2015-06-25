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
import org.jgrasstools.modules.RasterSummary; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculate a summary of the map with base statistics.")
public class RasterSummaryAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(RasterSummaryAlgorithm.class); 

  public RasterSummaryAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster;

  @LiteralDataInput(identifier = "inRaster", abstrakt = "The map to analize.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster(String inraster) { 
    this.inraster = inraster;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pbins;

  @LiteralDataInput(identifier = "pBins", abstrakt = "The number of bins for the histogram (default = 100).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpBins(int pbins) { 
    this.pbins = pbins;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dohistogram;

  @LiteralDataInput(identifier = "doHistogram", abstrakt = "Flag that defines if the histogram should be done also (default = false).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoHistogram(Boolean dohistogram) { 
    this.dohistogram = dohistogram;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double res_outmin;

  @LiteralDataOutput(identifier = "res_outMin", abstrakt = "The min value.", binding = LiteralDoubleBinding.class)
  public Double getRes_outMin() { 
    return res_outmin;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double res_outmax;

  @LiteralDataOutput(identifier = "res_outMax", abstrakt = "The max value.", binding = LiteralDoubleBinding.class)
  public Double getRes_outMax() { 
    return res_outmax;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double res_outmean;

  @LiteralDataOutput(identifier = "res_outMean", abstrakt = "The mean value.", binding = LiteralDoubleBinding.class)
  public Double getRes_outMean() { 
    return res_outmean;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double res_outsdev;

  @LiteralDataOutput(identifier = "res_outSdev", abstrakt = "The standard deviation value.", binding = LiteralDoubleBinding.class)
  public Double getRes_outSdev() { 
    return res_outsdev;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double res_outrange;

  @LiteralDataOutput(identifier = "res_outRange", abstrakt = "The range value.", binding = LiteralDoubleBinding.class)
  public Double getRes_outRange() { 
    return res_outrange;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double res_outsum;

  @LiteralDataOutput(identifier = "res_outSum", abstrakt = "The sum value.", binding = LiteralDoubleBinding.class)
  public Double getRes_outSum() { 
    return res_outsum;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = double[][]
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outcb;

  @LiteralDataOutput(identifier = "res_outCb", abstrakt = "The histogram.", binding = LiteralStringBinding.class)
  public String getRes_outCb() { 
    return res_outcb;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.RasterSummaryAlgorithm");
    
    RasterSummary tmpModule = new RasterSummary(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("doHistogram",  (Boolean) dohistogram); 
    logger.info("doHistogram " + ( (Boolean) dohistogram) );
    inputs.put("pBins",  (int) pbins); 
    logger.info("pBins " + ( (int) pbins) );
    
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
    
    outputs.put("outSum", "Double"); 
    outputs.put("outMax", "Double"); 
    outputs.put("outMean", "Double"); 
    outputs.put("outMin", "Double"); 
    outputs.put("outRange", "Double"); 
    outputs.put("outSdev", "Double"); 
    outputs.put("outCb", "String"); 
    
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outSum")) { 
            // and put them into the output result variables 
            res_outsum = (Double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outMax")) { 
            // and put them into the output result variables 
            res_outmax = (Double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outMean")) { 
            // and put them into the output result variables 
            res_outmean = (Double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outMin")) { 
            // and put them into the output result variables 
            res_outmin = (Double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outRange")) { 
            // and put them into the output result variables 
            res_outrange = (Double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outSdev")) { 
            // and put them into the output result variables 
            res_outsdev = (Double) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outCb")) { 
            // and put them into the output result variables 
            res_outcb = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

