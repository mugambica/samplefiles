package com.example.demo.layer4;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.layer2.Cancelticket;
import com.example.demo.layer3.CancelticketRepository;
import com.example.demo.layer4.exceptions.TicketNumberAlreadyExistsException;
import com.example.demo.layer4.exceptions.TicketNumberNotFoundException;


public class CancelticketServiceImpl implements CancelticketService {
	
	@Autowired
	CancelticketRepository canTktRepo;

	@Override
	public void addCancelticket(Cancelticket ctRef)throws TicketNumberAlreadyExistsException {
		try
		{
		canTktRepo.addCancelticket(ctRef);
		
	}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				throw new TicketNumberAlreadyExistsException("CancelId already exists");
				
			}
	}

	@Override
	public Cancelticket findCancelticket(int cancelid) throws TicketNumberNotFoundException {
		try
		{
			return canTktRepo.findCancelticket(cancelid);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			throw new TicketNumberNotFoundException("Cancelticket not found");
		}
	
	
		
	}

	@Override
	public Set<Cancelticket> findCancelticket() {
		
		return canTktRepo.findCancelticket();
	}


	@Override
	public void modifyCancelticket(Cancelticket ctRef)throws TicketNumberNotFoundException {
		Cancelticket ctRef1=canTktRepo.findCancelticket(ctRef.getCancelid());
		if(ctRef1!=null)
		{
			canTktRepo.modifyCancelticket(ctRef);
		}
		else
		{
			throw new TicketNumberNotFoundException("CancelId  not found");
		}
		
	}

	@Override
	public void removeCancelticket(int cancelid)throws TicketNumberNotFoundException {
		Cancelticket ctRef1=canTktRepo.findCancelticket(cancelid);
		if(ctRef1!=null)
		{
			canTktRepo.removeCancelticket(ctRef1.getCancelid());
		}
		else
		{
			throw new TicketNumberNotFoundException("CancelId  not found");
		}
		
	}

}