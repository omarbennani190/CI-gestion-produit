package com.examen_ci.gestion_produit;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProduitTest 
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    /**
     * Unit test for create product.
     */
    @Test
    public void createWithInvalidPrice()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("invalid");

        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", -200, 10));
    }
    @Test
    public void createWithInvalidQuantity()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("invalid");

        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, -10));
    }
    @Test
    public void createWithInvalidPriceAndQuantity()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("invalid");

        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", -200, -10));
    }

    @Test
    public void createWithExistingId()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("exist");

        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));
        ProduitService.create(new Produit(Long.parseLong("1"), "keyborad", 400, 8));
    }
    @Test
    public void createWithExistingName()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("exist");

        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));
        ProduitService.create(new Produit(Long.parseLong("2"), "mouse", 400, 8));
    }
    @Test
    public void createWithExistingIdAndName()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("exist");

        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));
        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 400, 8));
    }

    @Test
    public void createValidAndNonExisting()
    {
        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));
        ProduitService.create(new Produit(Long.parseLong("2"), "keyborad", 400, 8));
        assertTrue(true);
    }
    
    
    /**
     * Unit test for read products.
     */
    @Test
    public void readFromEmptyFile(){
        assertTrue(ProduitService.read().isEmpty());
    }
    @Test
    public void readFromNonEmptyFile(){
        ProduitService.create(new Produit(Long.parseLong("3"), "table", 1500, 8));
        assertFalse(ProduitService.read().isEmpty());
    }
    
    
    /**
     * Unit test for update product.
     */
    @Test
    public void updateNonExisting(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("does not exist");

        ProduitService.update(new Produit(Long.parseLong("1"), "mouse", 200, 10));
    }

    @Test
    public void updateWithInvalidPrice()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("invalid");
        
        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));

        ProduitService.update(new Produit(Long.parseLong("1"), "mouse", -200, 10));
    }
    @Test
    public void updateWithInvalidQuantity()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("invalid");

        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));

        ProduitService.update(new Produit(Long.parseLong("1"), "mouse", 200, -10));
    }
    @Test
    public void updateWithInvalidPriceAndQuantity()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("invalid");
        
        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));
        
        ProduitService.update(new Produit(Long.parseLong("1"), "mouse", -200, -10));
    }
    
    @Test
    public void updateExistingAndValidWithExistingName()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("name is already in use");

        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));
        ProduitService.create(new Produit(Long.parseLong("2"), "keyborad", 400, 8));

        ProduitService.update(new Produit(Long.parseLong("2"), "mouse", 500, 20));
    }

    @Test
    public void updateExistingAndValid()
    {
        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));
        ProduitService.create(new Produit(Long.parseLong("2"), "keyborad", 400, 8));

        ProduitService.update(new Produit(Long.parseLong("2"), "headset", 500, 20));
        assertTrue(true);
    }
    
    
    /**
     * Unit test for delete products.
     */
    @Test
    public void deleteNonExisting(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("does not exist");

        ProduitService.delete(1L);
    }
    @Test
    public void deleteExisting(){
        ProduitService.create(new Produit(Long.parseLong("1"), "mouse", 200, 10));
        ProduitService.delete(1L);
        
        assertTrue(true);
    }
    

    @After
    public void After()
    {
        File file = new File("products.json");
        if (file.exists()) {
            file.delete();
        }
    }
}
