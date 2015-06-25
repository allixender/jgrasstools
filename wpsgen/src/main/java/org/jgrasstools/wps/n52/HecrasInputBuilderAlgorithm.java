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
import org.jgrasstools.modules.HecrasInputBuilder; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module that prepares data for Hecras.")
public class HecrasInputBuilderAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(HecrasInputBuilderAlgorithm.class); 

  public HecrasInputBuilderAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The map of elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inriver;

  @LiteralDataInput(identifier = "inRiver", abstrakt = "The map of the river.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRiver(String inriver) { 
    this.inriver = inriver;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inbridges;

  @LiteralDataInput(identifier = "inBridges", abstrakt = "The map of bridges to consider.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinBridges(String inbridges) { 
    this.inbridges = inbridges;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String insections;

  @LiteralDataInput(identifier = "inSections", abstrakt = "The map of sections to consider. If supplied, they are used instead of extracting at a given interval. The sections need to be created with this same module.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSections(String insections) { 
    this.insections = insections;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ptitle;

  @LiteralDataInput(identifier = "pTitle", abstrakt = "The id of the river/simulation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpTitle(String ptitle) { 
    this.ptitle = ptitle;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double psectionsintervaldistance;

  @LiteralDataInput(identifier = "pSectionsIntervalDistance", abstrakt = "The sections interval distance.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSectionsIntervalDistance(double psectionsintervaldistance) { 
    this.psectionsintervaldistance = psectionsintervaldistance;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double psectionswidth;

  @LiteralDataInput(identifier = "pSectionsWidth", abstrakt = "The section width.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSectionsWidth(double psectionswidth) { 
    this.psectionswidth = psectionswidth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pbridgebuffer;

  @LiteralDataInput(identifier = "pBridgeBuffer", abstrakt = "The bridge buffer.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpBridgeBuffer(double pbridgebuffer) { 
    this.pbridgebuffer = pbridgebuffer;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fbridgewidth;

  @LiteralDataInput(identifier = "fBridgeWidth", abstrakt = "The bridge width.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfBridgeWidth(String fbridgewidth) { 
    this.fbridgewidth = fbridgewidth;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inhecras;

  @LiteralDataInput(identifier = "inHecras", abstrakt = "The path to the generated hecras.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinHecras(String inhecras) { 
    this.inhecras = inhecras;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outsections;

  @LiteralDataInput(identifier = "outSections", abstrakt = "The extracted section lines.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutSections(String outsections) { 
    this.outsections = outsections;
  }

  private String res_outsections;

  @LiteralDataOutput(identifier = "res_outSections", abstrakt = "The extracted section lines.", binding = LiteralStringBinding.class)
  public String getRes_outSections() { 
    return res_outsections;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outsectionpoints;

  @LiteralDataInput(identifier = "outSectionPoints", abstrakt = "The extracted section points (with the elevation in the attribute table).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutSectionPoints(String outsectionpoints) { 
    this.outsectionpoints = outsectionpoints;
  }

  private String res_outsectionpoints;

  @LiteralDataOutput(identifier = "res_outSectionPoints", abstrakt = "The extracted section points (with the elevation in the attribute table).", binding = LiteralStringBinding.class)
  public String getRes_outSectionPoints() { 
    return res_outsectionpoints;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.HecrasInputBuilderAlgorithm");
    
    HecrasInputBuilder tmpModule = new HecrasInputBuilder(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pBridgeBuffer",  (double) pbridgebuffer); 
    logger.info("pBridgeBuffer " + ( (double) pbridgebuffer) );
    inputs.put("pTitle",  (String) ptitle); 
    logger.info("pTitle " + ( (String) ptitle) );
    inputs.put("fBridgeWidth",  (String) fbridgewidth); 
    logger.info("fBridgeWidth " + ( (String) fbridgewidth) );
    inputs.put("outSections",  (String) outsections); 
    logger.info("outSections " + ( (String) outsections) );
    inputs.put("pSectionsIntervalDistance",  (double) psectionsintervaldistance); 
    logger.info("pSectionsIntervalDistance " + ( (double) psectionsintervaldistance) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("inSections",  (String) insections); 
    logger.info("inSections " + ( (String) insections) );
    inputs.put("inBridges",  (String) inbridges); 
    logger.info("inBridges " + ( (String) inbridges) );
    inputs.put("inRiver",  (String) inriver); 
    logger.info("inRiver " + ( (String) inriver) );
    inputs.put("pSectionsWidth",  (double) psectionswidth); 
    logger.info("pSectionsWidth " + ( (double) psectionswidth) );
    inputs.put("outSectionPoints",  (String) outsectionpoints); 
    logger.info("outSectionPoints " + ( (String) outsectionpoints) );
    inputs.put("inHecras",  (String) inhecras); 
    logger.info("inHecras " + ( (String) inhecras) );
    
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
    
    outputs.put("outSections", "String"); 
    outputs.put("outSectionPoints", "String"); 
    
    res_outsections = (String) outsections; 
    res_outsectionpoints = (String) outsectionpoints; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outSections")) { 
            // and put them into the output result variables 
            res_outsections = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outSectionPoints")) { 
            // and put them into the output result variables 
            res_outsectionpoints = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

