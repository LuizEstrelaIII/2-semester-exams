import java.util.Scanner;

public class Veiculo {
    public String[] modelos;
    public String[] placas;
    public int numCarros;

    public Veiculo(int carros) {
        modelos = new String[carros];
        placas = new String[carros];
        numCarros = 0;
    }

    public void executar() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            menu();
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                cadastrarVeiculo(sc);
            } else if (opcao == 2) {
                consultarVeiculo(sc);
            } else if (opcao == 3) {
                listarVeiculos();
            } else if (opcao == 0) {
                System.out.println("Saindo do programa");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void menu() {
        System.out.println("1. Cadastrar veículo");
        System.out.println("2. Consultar veículos");
        System.out.println("3. Listar veículos");
        System.out.println("0. Sair do programa");
        System.out.print("Escolha uma opção: ");
    }

    public void cadastrarVeiculo(Scanner sc) {
        System.out.print("Digite o modelo do carro: ");
        String modelo = sc.nextLine();
        System.out.print("Digite a placa do carro: ");
        String placa = sc.nextLine();

        modelos[numCarros] = modelo;
        placas[numCarros] = placa;
        numCarros++;

        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void consultarVeiculo(Scanner sc) {
        System.out.print("Digite a placa do seu carro: ");
        String placa = sc.nextLine();

        int indice = buscarVeiculo(placa, 0);
        if (indice != -1) {
            System.out.println("Modelo: " + modelos[indice]);
            System.out.println("Placa: " + placas[indice]);
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }

    public int buscarVeiculo(String placa, int indice) {
        if (indice >= numCarros) {
            return -1;
        }

        if (placas[indice].equalsIgnoreCase(placa)) {
            return indice;
        } else {
            return buscarVeiculo(placa, indice + 1);
        }
    }

    public void listarVeiculos() {
        System.out.println("\nLista de Veículos:");
        for (int i = 0; i < numCarros; i++) {
            System.out.println("Modelo: " + modelos[i]);
            System.out.println("Placa: " + placas[i]);
        }
    }

    
}

