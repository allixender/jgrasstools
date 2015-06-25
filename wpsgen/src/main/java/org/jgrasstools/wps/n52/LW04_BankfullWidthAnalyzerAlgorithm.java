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
import org.jgrasstools.modules.LW04_BankfullWidthAnalyzer; 
 
@Algorithm(version = "1.0.0", abstrakt = "Extracts the bankfull width for each section of the channels and adds it as an attribute to the input layer.")
public class LW04_BankfullWidthAnalyzerAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LW04_BankfullWidthAnalyzerAlgorithm.class); 

  public LW04_BankfullWidthAnalyzerAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inbankfull;

  @LiteralDataInput(identifier = "inBankfull", abstrakt = "The input polygon layer of the bankfull area.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinBankfull(String inbankfull) { 
    this.inbankfull = inbankfull;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innetpoints;

  @LiteralDataInput(identifier = "inNetPoints", abstrakt = "The input hierarchy point network layer.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNetPoints(String innetpoints) { 
    this.innetpoints = innetpoints;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double pmaxdistancefromnetpoint;

  @LiteralDataInput(identifier = "pMaxDistanceFromNetpoint", abstrakt = "The maximum distance that a point can have from the nearest polygon. If distance is major, then the netpoint is ignored and identified as outside the region of interest.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpMaxDistanceFromNetpoint(double pmaxdistancefromnetpoint) { 
    this.pmaxdistancefromnetpoint = pmaxdistancefromnetpoint;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double pmaxnetworkwidth;

  @LiteralDataInput(identifier = "pMaxNetworkWidth", abstrakt = "The maximum width for the channel network", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpMaxNetworkWidth(double pmaxnetworkwidth) { 
    this.pmaxnetworkwidth = pmaxnetworkwidth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double pminnetworkwidth;

  @LiteralDataInput(identifier = "pMinNetworkWidth", abstrakt = "The minimum width for the channel network", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpMinNetworkWidth(double pminnetworkwidth) { 
    this.pminnetworkwidth = pminnetworkwidth;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnetpoints;

  @LiteralDataInput(identifier = "outNetPoints", abstrakt = "The output points network layer with the additional attribute of bankfull width.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNetPoints(String outnetpoints) { 
    this.outnetpoints = outnetpoints;
  }

  private String res_outnetpoints;

  @LiteralDataOutput(identifier = "res_outNetPoints", abstrakt = "The output points network layer with the additional attribute of bankfull width.", binding = LiteralStringBinding.class)
  public String getRes_outNetPoints() { 
    return res_outnetpoints;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outproblempoints;

  @LiteralDataInput(identifier = "outProblemPoints", abstrakt = "The output points layer highlighting the position of the problematic sections.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutProblemPoints(String outproblempoints) { 
    this.outproblempoints = outproblempoints;
  }

  private String res_outproblempoints;

  @LiteralDataOutput(identifier = "res_outProblemPoints", abstrakt = "The output points layer highlighting the position of the problematic sections.", binding = LiteralStringBinding.class)
  public String getRes_outProblemPoints() { 
    return res_outproblempoints;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outbankfullsections;

  @LiteralDataInput(identifier = "outBankfullSections", abstrakt = "The output layer with the sections lines where the bankfull width has been calculated.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutBankfullSections(String outbankfullsections) { 
    this.outbankfullsections = outbankfullsections;
  }

  private String res_outbankfullsections;

  @LiteralDataOutput(identifier = "res_outBankfullSections", abstrakt = "The output layer with the sections lines where the bankfull width has been calculated.", binding = LiteralStringBinding.class)
  public String getRes_outBankfullSections() { 
    return res_outbankfullsections;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LW04_BankfullWidthAnalyzerAlgorithm");
    
    LW04_BankfullWidthAnalyzer tmpModule = new LW04_BankfullWidthAnalyzer(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inNetPoints",  (String) innetpoints); 
    logger.info("inNetPoints " + ( (String) innetpoints) );
    inputs.put("pMaxDistanceFromNetpoint",  (double) pmaxdistancefromnetpoint); 
    logger.info("pMaxDistanceFromNetpoint " + ( (double) pmaxdistancefromnetpoint) );
    inputs.put("outProblemPoints",  (String) outproblempoints); 
    logger.info("outProblemPoints " + ( (String) outproblempoints) );
    inputs.put("outBankfullSections",  (String) outbankfullsections); 
    logger.info("outBankfullSections " + ( (String) outbankfullsections) );
    inputs.put("pMaxNetworkWidth",  (double) pmaxnetworkwidth); 
    logger.info("pMaxNetworkWidth " + ( (double) pmaxnetworkwidth) );
    inputs.put("outNetPoints",  (String) outnetpoints); 
    logger.info("outNetPoints " + ( (String) outnetpoints) );
    inputs.put("inBankfull",  (String) inbankfull); 
    logger.info("inBankfull " + ( (String) inbankfull) );
    inputs.put("pMinNetworkWidth",  (double) pminnetworkwidth); 
    logger.info("pMinNetworkWidth " + ( (double) pminnetworkwidth) );
    
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
    
    outputs.put("outProblemPoints", "String"); 
    outputs.put("outBankfullSections", "String"); 
    outputs.put("outNetPoints", "String"); 
    
    res_outproblempoints = (String) outproblempoints; 
    res_outbankfullsections = (String) outbankfullsections; 
    res_outnetpoints = (String) outnetpoints; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outProblemPoints")) { 
            // and put them into the output result variables 
            res_outproblempoints = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outBankfullSections")) { 
            // and put them into the output result variables 
            res_outbankfullsections = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outNetPoints")) { 
            // and put them into the output result variables 
            res_outnetpoints = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

