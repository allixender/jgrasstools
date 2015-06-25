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
import org.jgrasstools.modules.SumDownStream; 
 
@Algorithm(version = "1.0.0", abstrakt = "Sums the values of a map downstream following the flowdirections.")
public class SumDownStreamAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(SumDownStreamAlgorithm.class); 

  public SumDownStreamAlgorithm() { 
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
  private String intosum;

  @LiteralDataInput(identifier = "inToSum", abstrakt = "The map to sum.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinToSum(String intosum) { 
    this.intosum = intosum;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pupperthres;

  @LiteralDataInput(identifier = "pUpperThres", abstrakt = "The upper threshold.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpUpperThres(Double pupperthres) { 
    this.pupperthres = pupperthres;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double plowerthres;

  @LiteralDataInput(identifier = "pLowerThres", abstrakt = "The lower threshold.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpLowerThres(Double plowerthres) { 
    this.plowerthres = plowerthres;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outsummed;

  @LiteralDataInput(identifier = "outSummed", abstrakt = "The map of summed values.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutSummed(String outsummed) { 
    this.outsummed = outsummed;
  }

  private String res_outsummed;

  @LiteralDataOutput(identifier = "res_outSummed", abstrakt = "The map of summed values.", binding = LiteralStringBinding.class)
  public String getRes_outSummed() { 
    return res_outsummed;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.SumDownStreamAlgorithm");
    
    SumDownStream tmpModule = new SumDownStream(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inToSum",  (String) intosum); 
    logger.info("inToSum " + ( (String) intosum) );
    inputs.put("pLowerThres",  (Double) plowerthres); 
    logger.info("pLowerThres " + ( (Double) plowerthres) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("pUpperThres",  (Double) pupperthres); 
    logger.info("pUpperThres " + ( (Double) pupperthres) );
    inputs.put("outSummed",  (String) outsummed); 
    logger.info("outSummed " + ( (String) outsummed) );
    
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
    
    outputs.put("outSummed", "String"); 
    
    res_outsummed = (String) outsummed; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outSummed")) { 
            // and put them into the output result variables 
            res_outsummed = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

