package view;

public class Menus {
    public static void showMainMenu() {
        String menuStr = """
                                
                ################################
                ##### LOCADORA DE VEÍCULOS #####
                ################################
                                
                >>>> Menu <<<<
                1 - Veículos
                2 - Clientes
                3 - Aluguéis
                4 - Sair
                """;

        System.out.println(menuStr);
    }

    public static void showVeiculosMenu() {
        String menuStr = """
                      
                >>>> Veículos <<<<
                1 - Buscar veículo
                2 - Cadastrar veículo
                3 - Alterar veículo
                4 - Voltar
                """;

        System.out.println(menuStr);
    }

    public static void showVeiculosTipoMenu() {
        String menuStr = """
                
                Informe o tipo do veículo:
                    1 - Pequeno
                    2 - Médio
                    3 - SUV
                """;
        System.out.println(menuStr);
    }

    public static void showClientesMenu() {
        String menuStr = """
                      
                >>>> Clientes <<<<
                1 - Buscar cliente
                2 - Cadastrar cliente
                3 - Alterar cliente
                4 - Voltar
                """;

        System.out.println(menuStr);
    }

    public static void showAlugueisMenu() {
        String menuStr = """
                      
                >>>> Aluguéis <<<<
                1 - Alugar veículo
                2 - Devolver veículo
                3 - Voltar
                """;

        System.out.println(menuStr);
    }
}
