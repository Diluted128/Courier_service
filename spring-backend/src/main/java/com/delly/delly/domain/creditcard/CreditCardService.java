package com.delly.delly.domain.creditcard;

import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.ClientRepository;
import com.delly.delly.exception.exceptions.EntityLimitException;
import com.delly.delly.exception.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditCardService {

    final CreditCardRepository creditCardRepository;
    final ClientRepository clientRepository;

    public String savePayment(String username, CreditCard creditCard){
        Client client = clientRepository.getClientByUsername(username);
        Set<CreditCard> creditCards = client.getCreditCards();
        if(client.getCreditCards().size() < 3){
            creditCard.setClient_id(client);
            creditCards.add(creditCard);
            client.setCreditCards(creditCards);
            clientRepository.save(client);
        }
        else{
            throw new EntityLimitException("Number of cards for client: " + client.getId() + " reached limit");
        }
        return "Card successfully saved";
    }

    public String updatePayment(String username, CreditCard newCreditCard, int cardID){
        Client client = clientRepository.getClientByUsername(username);

        Optional<CreditCard> creditCardToUpdateOptional  = client.getCreditCards().stream()
                .filter((payment) -> payment.getID() == cardID)
                .findFirst();

        if(creditCardToUpdateOptional.isPresent()){
            CreditCard creditCardToUpdate = creditCardToUpdateOptional.get();
                    creditCardToUpdate.setCardNumber(newCreditCard.getCardNumber());
                    creditCardToUpdate.setExpiredDate(newCreditCard.getExpiredDate());
                    creditCardToUpdate.setCvv(newCreditCard.getCvv());

           client.setCreditCards( client.getCreditCards().stream()
                   .map((element) -> element.getID() == cardID ? creditCardToUpdate : element)
                   .collect(Collectors.toSet())
           );

            clientRepository.save(client);

            return "Card " + creditCardToUpdate.getID() + " successfully updated";
        }
        else
            throw new EntityNotFoundException("Card " + cardID + " not found.");
    }

    @Transactional
    public String deletePayment(String username, int cardID){
        Client client = clientRepository.getClientByUsername(username);

        Optional<CreditCard> creditCard = client.getCreditCards().stream()
                .filter((element) -> element.getID() == cardID)
                .findFirst();

        if(creditCard.isPresent()){
            client.setCreditCards(client.getCreditCards().stream()
                    .filter(element -> element.getID() != cardID)
                    .collect(Collectors.toSet()));
            clientRepository.save(client);
            creditCardRepository.deleteCreditCardByID(cardID);
        }
        else{
            throw new EntityNotFoundException("Credit card with id: " + cardID + " was not found.");
        }

        return "Credit card with id: " + cardID + " has been successfully removed";
    }
}
