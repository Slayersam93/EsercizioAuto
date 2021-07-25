package it.epicode.be.Garage;

import java.util.List;
import java.util.Scanner;

import it.epicode.be.Garage.model.Automobile;
import it.epicode.be.Garage.model.Colore;
import it.epicode.be.Garage.model.Persona;
import it.epicode.be.Garage.persistence.AutomobileDAO;
import it.epicode.be.Garage.persistence.PersonaDAO;
import it.epicode.be.Garage.util.JpaUtil;

public class App {
	private Scanner scanner = new Scanner(System.in);
	AutomobileDAO ad = new AutomobileDAO();
	PersonaDAO pd = new PersonaDAO();

	public static void main(String[] args) {
		JpaUtil.apriSessione();
		App display = new App();
		int select = -1;
		while (select != 0) {
			display.menu();
			select = Integer.parseInt(display.scanner.nextLine());
			switch (select) {
			case 0:
				System.out.println("Grazie e arrivederci");
				break;

			case 1:
				display.listaAuto();
				break;

			case 2:
				display.salvaAuto();
				break;
			case 3:
				display.listaAuto();
				display.eliminaAuto();
				break;
			case 4:
				display.listaAuto();
				display.aggiornaAuto();
				break;
			case 5:
				display.eliminaProprietario();
				break;

			default:
				display.errore();
			}
		}

		JpaUtil.chiudiSessione();
	}

	public void menu() {
		System.out.println("Inserisci 1 per vedere tutte le auto");
		System.out.println("Inserisci 2 per inserire una nuova auto");
		System.out.println("Inserisci 3 per eliminare un auto");
		System.out.println("Inserisci 4 per modificare un auto");
		System.out.println("Inserisci 5 per eliminare un proprietario");
		System.out.println("Inserisci 0 per terminare il programma");
	}

	public void errore() {
		System.out.println("Errore il numero selezionato non ha funzioni");
	}

	public void listaAuto() {

		List<Automobile> lista = ad.getAuto();
		for (Automobile a : lista) {
			System.out.println(a);
		}
	}

	public void salvaAuto() {

		System.out.println("Inserisci i dati del Proprietario");
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Cognome: ");
		String cognome = scanner.nextLine();
		Persona proprietario = new Persona(nome, cognome);
		pd.save(proprietario);
		System.out.println("Inseisci i dati dell'auto");
		System.out.println("Inserisci il modello: ");
		String modello = scanner.nextLine();
		System.out.println("Inserisci la marca: ");
		String marca = scanner.nextLine();
		System.out.println("Inserisci il numeroTelaio: ");
		String numeroTelaio = scanner.nextLine();
		System.out.println("Scegli il colore della macchina: ");
		Colore[] arrayColori = Colore.values();
		for (Colore c : arrayColori) {
			System.out.println(c.ordinal() + " " + c.toString());
		}
		int progColore = Integer.parseInt(scanner.nextLine());
		Colore selezionato = arrayColori[progColore];
		Automobile auto = new Automobile(modello, marca, numeroTelaio, selezionato, proprietario);
		ad.save(auto);

	}

	public void eliminaAuto() {
		System.out.println("Scegli l'auto da eliminare e digita il numero corrispondente al sui Id");
		long id = Long.parseLong(scanner.nextLine());
		ad.deleteByID(id);

	}

	public void eliminaProprietario() {
		List<Persona> lista = pd.getPersona();
		for (Persona a : lista) {
			System.out.println(a);
		}
		System.out.println("Scegli il proprietario da eliminare e digita il numero corrispondente al sui Id");
		long ID = Long.parseLong(scanner.nextLine());
		pd.deleteByID(ID);
	}

	public void aggiornaAuto() {
		System.out.println("Scegli l'auto da modificare e digita il numero corrispondente al sui Id");
		long id = Long.parseLong(scanner.nextLine());
		Automobile auto = ad.getById(id);
		int select = -1;
		while (select != 0) {
			System.out.println("Seleziona il dato da modificare");
			System.out.println("Per modificare il modello digita 1");
			System.out.println("Per modificare la marca digita 2");
			System.out.println("Per modificare il numero di telaio digita 3");
			System.out.println("Per modificare il colore digita 4 ");
			System.out.println("Per modificare il proprietario digita 5");
			System.out.println("Per annullare le modifiche effettuate digita 6");
			System.out.println("Digita 0 per uscire");
			select = Integer.parseInt(scanner.nextLine());
			switch (select) {
			case 1:
				System.out.println("Inserisci il nuovo modello");
				String modello = scanner.nextLine();
				auto.setModello(modello);
				break;
			case 2:
				System.out.println("Inserisci la nuova marca");
				String marca = scanner.nextLine();
				auto.setMarca(marca);
				break;
			case 3:
				System.out.println("Inserisci il nuovo numero di telaio");
				String numeroDITelaio = scanner.nextLine();
				auto.setNumeroTelaio(numeroDITelaio);
				break;
			case 4:
				System.out.println("Inserisci il nuovo colore");
				Colore[] arrayColori = Colore.values();
				for (Colore c : arrayColori) {
					System.out.println(c.ordinal() + " " + c.toString());
					int progColore = Integer.parseInt(scanner.nextLine());
					Colore selezionato = arrayColori[progColore];
					auto.setColore(selezionato);
				}
				break;
			case 5:
				Persona proprietario = auto.getProprietario();
				System.out.println(proprietario);

				int x = -1;
				while (x != 0) {
					System.out.println("Per modificare il nome digita 1");
					System.out.println("Per modificare il cognome digita 2");
					System.out.println("Per annullare le modifiche digita 3");
					System.out.println("Per uscire e salvare le modifiche effettuate digita 0");
					x = Integer.parseInt(scanner.nextLine());
					switch (x) {
					case 1:
						System.out.println("Inserisci il nuovo nome ");
						String nome = scanner.nextLine();
						proprietario.setNome(nome);
						break;

					case 2:
						System.out.println("Inserisci il nuovo cognome ");
						String cognome = scanner.nextLine();
						proprietario.setCogmone(cognome);
						break;

					case 3:
						pd.refresh(proprietario);
						break;
					case 0:
						pd.save(proprietario);
						break;
					default:
						errore();
					}
				}
			case 6:
				ad.refresh(auto);
				break;
			case 0:
				ad.save(auto);
				break;
			default:
				errore();
			}
		}
	}
}
