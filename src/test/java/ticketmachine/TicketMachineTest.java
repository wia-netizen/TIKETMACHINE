package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de
	// l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		// Les montants ont été correctement additionnés
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");
	}
	@Test
		//S3: N'imprine pas si pas assez d'argent
	void nImprimePasSiBalanceInsuffisante(){
		//GIVEN: une machine vierge (initialisée dans @BeforeEach)
		//WHEN on ne met pas assez d'argent
		machine.insertMoney( PRICE-1);
		//THEN ça n'imprime pas
		assertFalse(machine.printTicket(),"Pas assez d'argent, on ne doit pas imprimer");
	}
	@Test
		//S4: imprine si assez d'argent
	void ImprimePasSiBalanceInsuffisante(){
		//GIVEN: une machine vierge (initialisée dans @BeforeEach)
		//WHEN on ne met pas assez d'argent
		machine.insertMoney( PRICE);
		//THEN ça n'imprime pas
		assertTrue(machine.printTicket(),"il y a assez d'argent, on doit imprimer");
	}
	@Test
		// S5 : La balance est réinitialisée après l'impression
	void balanceIsResetAfterPrinting() {
		machine.insertMoney(PRICE);
		machine.printTicket();
		assertEquals(0, machine.getBalance(), "La balance devrait être réinitialisée à 0 après impression");
	}



}
