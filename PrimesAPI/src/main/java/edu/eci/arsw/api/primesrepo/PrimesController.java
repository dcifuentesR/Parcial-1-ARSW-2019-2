package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController
public class PrimesController
{
	@Autowired
    PrimeService primeService=null;


    @RequestMapping( value = "/primes", method = GET )
    public ResponseEntity<?> getPrimesHandler()
    {
    	try {
        return new ResponseEntity<>(primeService.getFoundPrimes(), HttpStatus.ACCEPTED);
    	}catch(Exception e) {
    		Logger.getLogger(PrimesController.class.getName()).log(null,e);
        return new ResponseEntity<>("no encontro primos", HttpStatus.NOT_FOUND);}
    }
    
    @RequestMapping(value="/primes/{primenumber}",method = GET)
    public ResponseEntity<?> getPrimeHandler(@PathVariable(value="primenumber") String prime){
    	try {
			return new ResponseEntity<>(primeService.getPrime(prime), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			Logger.getLogger(PrimesController.class.getName()).log(null,e);
			return new ResponseEntity<>("no encontro el primo",HttpStatus.NOT_FOUND);
		}
    	
    }
    
    @RequestMapping(value="/primes/{prime}", method = RequestMethod.POST)
    public ResponseEntity<?> postPrimesHandler(@RequestBody FoundPrime prime){
    	primeService.addFoundPrime(prime);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }


    //TODO implement additional methods provided by PrimeService



}
