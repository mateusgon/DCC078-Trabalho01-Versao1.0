package action;

import PadraoComposite.Bebida;
import PadraoComposite.ItemDeVenda;
import PadraoComposite.PratoDeEntrada;
import PadraoComposite.PratoPrincipal;
import PadraoComposite.Sobremesa;
import PadraoStateObserverMemento.Cliente;
import PadraoStateObserverMemento.Pedido;
import PadraoStateObserverMemento.PedidoEstadoAberto;
import PadraoStrategy.MetodoPagamento;
import PadraoStrategy.MetodoPagamentoCartaoCredito;
import PadraoStrategy.MetodoPagamentoCartaoDebito;
import PadraoStrategy.MetodoPagamentoDinheiro;
import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.Produto;
import persistence.ComboDAO;
import persistence.PedidoDAO;
import persistence.PessoaDAO;
import persistence.ProdutoDAO;

public class FazerPedidoPostAction implements Action {

    Integer pagamento;
    Integer idRestaurante;
    Integer idUsr;
    Pedido pedido;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        pedido = new Pedido();

        pagamento = Integer.parseInt(request.getParameter("pagamento"));
        idUsr = Integer.parseInt(request.getParameter("idUsr"));
        idRestaurante = Integer.parseInt(request.getParameter("idRest"));

        pedido = pedido.setIdCliente(idUsr).setIdRestaurante(idRestaurante).setNumeroPedido(PedidoDAO.getInstance().savePedido(pedido)).setEstado(new PedidoEstadoAberto(pedido));;

        String[] posicoes = request.getParameterValues("entrada");
        String[] posicoes2 = request.getParameterValues("principal");
        String[] posicoes3 = request.getParameterValues("bebida");
        String[] posicoes4 = request.getParameterValues("sobremesa");
        String[] posicoes5 = request.getParameterValues("combo");
        if (posicoes != null && posicoes.length > 0) {
            Integer[] requisicao = new Integer[posicoes.length];
            for (int i = 0; i < posicoes.length; i++) {
                requisicao[i] = Integer.parseInt(posicoes[i]);
                instanciaObjeto(ProdutoDAO.getInstance().listProduto(requisicao[i]));
            }
        }
        if (posicoes2 != null && posicoes2.length > 0) {
            Integer[] requisicao2 = new Integer[posicoes2.length];
            for (int i = 0; i < posicoes2.length; i++) {
                requisicao2[i] = Integer.parseInt(posicoes2[i]);
                instanciaObjeto(ProdutoDAO.getInstance().listProduto(requisicao2[i]));
            }
        }
        if (posicoes3 != null && posicoes3.length > 0) {
            Integer[] requisicao3 = new Integer[posicoes3.length];
            for (int i = 0; i < posicoes3.length; i++) {
                requisicao3[i] = Integer.parseInt(posicoes3[i]);
                instanciaObjeto(ProdutoDAO.getInstance().listProduto(requisicao3[i]));
            }
        }
        if (posicoes4 != null && posicoes4.length > 0) {
            Integer[] requisicao4 = new Integer[posicoes4.length];
            for (int i = 0; i < posicoes4.length; i++) {
                requisicao4[i] = Integer.parseInt(posicoes4[i]);
                instanciaObjeto(ProdutoDAO.getInstance().listProduto(requisicao4[i]));
            }
        }

        PedidoDAO.getInstance().savePedidoProduto(pedido.getItens(), pedido.getNumeroPedido());

        if (posicoes5 != null && posicoes5.length > 0) {
            Integer[] requisicao5 = new Integer[posicoes5.length];
            for (int i = 0; i < posicoes5.length; i++) {
                requisicao5[i] = Integer.parseInt(posicoes5[i]);
                ItemDeVenda combo = ComboDAO.getInstance().searchComboEspecifico(requisicao5[i]);
                List<Integer> idProdutos = ComboDAO.getInstance().searchComboProduto(requisicao5[i]);
                for (Integer idProduto : idProdutos) {
                    Produto produto = ProdutoDAO.getInstance().listProduto(idProduto);
                    instanciaCombo(produto, combo);
                }
                PedidoDAO.getInstance().saveComboProduto(combo, pedido.getNumeroPedido());
                pedido.getItens().add(combo);
            }
        }

        Pessoa pessoa = PessoaDAO.getInstance().buscaUsuario(idUsr);

        Cliente cliente = new Cliente(pessoa.getPessoaCod(), pessoa.getTipoPessoa(), pessoa.getNome(), pessoa.getEndereco(), pessoa.getEmail(), null, pessoa.getTelefone(), pedido);
        cliente.notificarAbertura();

        setDificuldade();
        calculaValor();
        PedidoDAO.getInstance().updatePedido(pedido);
        
        pedido.saveToMemento();

        request.setAttribute("idRest", idRestaurante);
        request.setAttribute("nomeUsuario", cliente.getNome());
        request.setAttribute("valor", pedido.getValor());
        request.setAttribute("idPedido", pedido.getNumeroPedido());
        request.setAttribute("idUsr", pedido.getIdCliente());
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-cliente-confirmar-pedido.jsp");
        dispatcher.forward(request, response);
    }

    public void instanciaObjeto(Produto produto) {
        switch (produto.getTipoItem()) {
            case 1:
                ItemDeVenda entrada = new PratoDeEntrada();
                entrada = entrada.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                pedido.getItens().add(entrada);
                break;
            case 2:
                ItemDeVenda principal = new PratoPrincipal();
                principal = principal.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                pedido.getItens().add(principal);
                break;
            case 3:
                ItemDeVenda bebida = new Bebida();
                bebida = bebida.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                pedido.getItens().add(bebida);
                break;
            case 4:
                ItemDeVenda sobremesa = new Sobremesa();
                sobremesa = sobremesa.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                pedido.getItens().add(sobremesa);
                break;
            default:
                break;
        }
    }

    public void instanciaCombo(Produto produto, ItemDeVenda combo) throws Exception {
        switch (produto.getTipoItem()) {
            case 1:
                ItemDeVenda entrada = new PratoDeEntrada();
                entrada = entrada.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                combo.adicionar(entrada);
                break;
            case 2:
                ItemDeVenda principal = new PratoPrincipal();
                principal = principal.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                combo.adicionar(principal);
                break;
            case 3:
                ItemDeVenda bebida = new Bebida();
                bebida = bebida.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                combo.adicionar(bebida);
                break;
            case 4:
                ItemDeVenda sobremesa = new Sobremesa();
                sobremesa = sobremesa.setCodigo(produto.getProdutocod()).setNome(produto.getNome()).setValor(produto.getValor()).setDificuldade(produto.getDificuldade()).setRestaurantecod(idRestaurante);
                combo.adicionar(sobremesa);
                break;
            default:
                break;
        }
    }

    public void setDificuldade() {
        List<ItemDeVenda> itens = pedido.getItens();
        for (ItemDeVenda iten : itens) {
            if (iten.getDificuldade() == 3) {
                pedido.setDificuldade(3);
                break;
            }
            pedido.setDificuldade(iten.getDificuldade());
        }
    }

    public void calculaValor() {
        MetodoPagamento metodo;
        List<ItemDeVenda> itens = pedido.getItens();
        Double valor = 0.0;
        for (ItemDeVenda iten : itens) {
            valor = valor + iten.getValor();
        }
        switch (pagamento) {
            case 1: {
                metodo = new MetodoPagamentoCartaoCredito();
                pedido.setValor(metodo.obterValor(valor));
                break;
            }
            case 2: {
                metodo = new MetodoPagamentoCartaoDebito();
                pedido.setValor(metodo.obterValor(valor));
                break;
            }
            case 3: {
                metodo = new MetodoPagamentoDinheiro();
                pedido.setValor(metodo.obterValor(valor));
                break;
            }
        }
    }
}
