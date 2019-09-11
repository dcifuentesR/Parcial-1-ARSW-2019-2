package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo 2/22/18.
 */
@Service("primeService")
public class PrimeServiceStub implements PrimeService {
	private List<FoundPrime> primes;

	public PrimeServiceStub() {
		primes = new LinkedList<>();

		primes.add(new FoundPrime("john", "3"));
		primes.add(new FoundPrime("arthur", "13"));
		primes.add(new FoundPrime("adler", "11"));
		primes.add(new FoundPrime("daniel", "15"));

	}

	@Override
	public void addFoundPrime(FoundPrime foundPrime) {
		primes.add(foundPrime);
	}

	@Override
	public List<FoundPrime> getFoundPrimes() {
		return primes;
	}

	@Override
	public FoundPrime getPrime(String prime) {
		FoundPrime resp = null;
		for (FoundPrime p : primes)
			if (p.getPrime().equals(prime)) {
				resp = p;
				break;
			}

		return resp;
	}
}
