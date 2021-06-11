/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import TechnicalServices.Persistence.TransferFromDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author boud-
 */
public class Catalog {

    // a product is defined by a price and a description
    private final Map<Integer, Product> descriptions = new HashMap();

    public Catalog() {
        // calls loadSpecs() & fills descriptions map
        loadSpecs();
    }

    public void loadSpecs() {
        // read items from the db & fill descriptions
        List<Product> ls = new ArrayList();
        ls = TransferFromDB.INSTANCE.findAllProduct();
        for (Product prod : ls) {
            //System.out.println(prod.toString());
            descriptions.put(prod.getItemId(), prod);// key & value
        }
    }

    public Product getProduct(int ItemdId) {
        return descriptions.get(ItemdId);
    }

    public List<Product> getDescriptions() {
        return new ArrayList(descriptions.values());
    }

}
