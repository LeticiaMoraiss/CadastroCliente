package View;

import Conexao.SQLSERVER.ComandoSQL;
import Modelo.Cliente;
import Modelo.ClienteTable;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Cadastro extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton inserir, remover, alterar, confirmar, cancelar, sair;
    Cliente cliente = new Cliente();
    String comando;
    Container tela = getContentPane();
    JTable tabela = new JTable();
    TabelaEditavel modelo = new TabelaEditavel();

    public Cadastro() {
        criarLabel();
        criarTextField();
        criarBotoes();
        desabilitarBotoes();
        desabilitarCampos();
        adicionarClick();
        adicionarComponetes();
        inserirTabela();
        configurarLayout();
    }

    /*============================================================ Funções Auxiliares ==================================================================*/
    public void limparCamposFormulario() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
    }

    public boolean validarFormulario() {
        boolean retorno = true;

        if (t2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " Nome do cliente esta vazio.");
            retorno = false;
        }
        if (t3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " Telefone redisencial do cliente esta vazio.");
            retorno = false;
        } else if (!t3.getText().matches("[0-9]*")) {
            JOptionPane.showMessageDialog(null, " Telefone redisencial do cliente não contem somente números.");
            retorno = false;
        }
        if (t4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " Telefone comercial do cliente esta vazio.");
            retorno = false;
        } else if (!t4.getText().matches("[0-9]*")) {
            JOptionPane.showMessageDialog(null, " Telefone comercial do cliente não contem somente números.");
            retorno = false;
        }
        if (t5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " Telefone celular do cliente esta vazio.");
            retorno = false;
        } else if (!t5.getText().matches("[0-9]*")) {
            JOptionPane.showMessageDialog(null, " Telefone celular do cliente não contem somente números.");
            retorno = false;
        }
        if (t6.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " E-mail do cliente esta vazio.");
            retorno = false;
        }

        return retorno;
    }

    public void desabilitarCampos() {
        //Desabilitando os campos
        t1.setEnabled(false);
        t2.setEnabled(false);
        t3.setEnabled(false);
        t4.setEnabled(false);
        t5.setEnabled(false);
        t6.setEnabled(false);
        t7.setEnabled(false);
    }

    public void desabilitarBotoes() {
        sair.setEnabled(true);
        inserir.setEnabled(true);
        alterar.setEnabled(false);
        remover.setEnabled(false);
        cancelar.setEnabled(false);
        confirmar.setEnabled(false);
    }

    public void habilitarCampos() {
        t2.setEnabled(true);
        t3.setEnabled(true);
        t4.setEnabled(true);
        t5.setEnabled(true);
        t6.setEnabled(true);
        t7.setEnabled(true);
    }

    public void adicionarClick() {
        inserir.addActionListener(this);
        remover.addActionListener(this);
        alterar.addActionListener(this);
        confirmar.addActionListener(this);
        cancelar.addActionListener(this);
        sair.addActionListener(this);
    }

    public void criarLabel() {
        //Adicionar Label
        l1 = new JLabel("Id:");
        l2 = new JLabel("Nome:");
        l3 = new JLabel("Tel.Residencial:");
        l4 = new JLabel("Tel.Comercial:");
        l5 = new JLabel("Tel.Celular:");
        l6 = new JLabel("E-mail:");
        l7 = new JLabel("Clientes Cadastrados");
        l8 = new JLabel(" _____________________________________________________________________________________________");

        //Adcionar tamanho do JLabel  
        l1.setBounds(15, 10, 60, 20);
        l2.setBounds(100, 10, 60, 20);
        l3.setBounds(15, 70, 100, 20);
        l4.setBounds(290, 70, 100, 20);
        l5.setBounds(560, 70, 100, 20);
        l6.setBounds(15, 125, 100, 20);
        l7.setBounds(15, 250, 1000, 20);
        l8.setBounds(150, 245, 800, 20);
    }

    public void criarTextField() {
        //Adicionar JTextField
        t1 = new JTextField(1);
        t2 = new JTextField(2);
        t3 = new JTextField(3);
        t4 = new JTextField(4);
        t5 = new JTextField(5);
        t6 = new JTextField(6);
        t7 = new JTextField(7);

        //Adcionar  JTextField
        t1.setBounds(15, 35, 50, 25);
        t2.setBounds(100, 35, 710, 25);
        t3.setBounds(15, 95, 250, 25);
        t4.setBounds(290, 95, 250, 25);
        t5.setBounds(560, 95, 250, 25);
        t6.setBounds(15, 150, 793, 25);

    }

    public void criarBotoes() {
        //Adicionar JButton
        inserir = new JButton("Inserir");
        remover = new JButton("Remover");
        alterar = new JButton("Alterar");
        confirmar = new JButton("Confirmar");
        cancelar = new JButton("Cancelar");
        sair = new JButton("Sair");

        //Adcionar tamanho do JButton  
        inserir.setBounds(15, 190, 100, 30);
        remover.setBounds(125, 190, 100, 30);
        alterar.setBounds(235, 190, 100, 30);
        confirmar.setBounds(345, 190, 100, 30);
        cancelar.setBounds(455, 190, 100, 30);
        sair.setBounds(707, 190, 100, 30);
    }

    public void adicionarComponetes() {
        tela.add(l1);
        tela.add(t1);
        tela.add(l2);
        tela.add(t2);
        tela.add(l3);
        tela.add(t3);
        tela.add(l4);
        tela.add(t4);
        tela.add(l5);
        tela.add(t5);
        tela.add(l6);
        tela.add(t6);
        tela.add(l7);
        tela.add(l8);
        tela.add(inserir);
        tela.add(remover);
        tela.add(alterar);
        tela.add(confirmar);
        tela.add(cancelar);
        tela.add(sair);
    }

    public void configurarLayout() {
        setLayout(null);
        setTitle("Cadastro de Clientes");
        setSize(830, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /*=============================================================== Funções OnClick ==================================================================*/
    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println(e.getActionCommand());
        if (null != e.getActionCommand()) {
            switch (e.getActionCommand()) {
                case "Inserir":
                    inserirDados();
                    break;
                case "Remover":
                    removerDados();
                    break;
                case "Alterar":
                    alterarDados();
                    break;
                case "Confirmar":
                    confirmarDados();
                    break;
                case "Cancelar":
                    cancelarDados();
                    break;
                case "Sair":
                    fecharCadastro();
                    break;
                default:
                    break;
            }
        }
    }

    /*=============================================================== Funções Tabela ==================================================================*/
    public void inserirTabela() {

        tabela.setPreferredScrollableViewportSize(new Dimension(700, 100));
        tabela.setFillsViewportHeight(true);
        tabela.getTableHeader().setReorderingAllowed(false); //Não permite mover as colunas de lugar
        tabela.setEnabled(true);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(15, 280, 790, 180);
        preencherTabela();
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() % 2 == 0) { //Força o duplo click
                    int idSelecionado = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);

                    try {
                        Cliente cliente = new Cliente();
                        ComandoSQL sql = new ComandoSQL();
                        cliente = sql.listarPorId(Integer.toString(idSelecionado));
                        clienteSelecionado(cliente);
                    } catch (Exception ex) {

                    }
                }
            }

        });
        tela.add(scrollPane);

    }

    /*=============================================================== Funções Listar ==================================================================*/
    public void preencherTabela() {
        modelo.limparTabela();
        try {
            ComandoSQL sql = new ComandoSQL();
            for (ClienteTable c : sql.listarTabela()) {
                modelo.addLinha(c);
            }

            tabela.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Falha ao listar cliente." + ex.getMessage());
        }
    }

    public void clienteSelecionado(Cliente cliente) {
        t1.setText(Integer.toString(cliente.id));
        t2.setText(cliente.nome);
        t3.setText(cliente.tel_Residencial);
        t4.setText(cliente.tel_Comercial);
        t5.setText(cliente.tel_Celular);
        t6.setText(cliente.email);
        desabilitarCampos();
        confirmar.setEnabled(false);
        cancelar.setEnabled(false);
        inserir.setEnabled(false);
        alterar.setEnabled(true);
        remover.setEnabled(true);
    }

    /*=============================================================== Funções Insert ==================================================================*/
    public void inserirDados() {
        comando = "Inserir";
        int codigo = JOptionPane.showConfirmDialog(null, "Deseja inserir um novo cliente?", "Cadastro", JOptionPane.YES_NO_OPTION);
        if (codigo == JOptionPane.YES_OPTION) {
            sair.setEnabled(false);
            inserir.setEnabled(false);
            confirmar.setEnabled(true);
            cancelar.setEnabled(true);
            try {
                ComandoSQL sql = new ComandoSQL();
                String id = sql.ultimoId();
                t1.setText(id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, " Falha ao gerar Id.");
            }

            habilitarCampos();
        } else {

        }
    }

    public void inserirSQL() {
        boolean isValid = validarFormulario();

        if (isValid == true) {
            cliente.nome = t2.getText();
            cliente.tel_Residencial = t3.getText();
            cliente.tel_Comercial = t4.getText();
            cliente.tel_Celular = t5.getText();
            cliente.email = t6.getText();
            //System.out.println(cliente.toString());
            try {
                ComandoSQL sql = new ComandoSQL();
                sql.inserir(cliente);
                limparCamposFormulario();
                desabilitarBotoes();
                desabilitarCampos();
                preencherTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, " Falha ao cadastrar cliente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, " Preencha o formulario corretamente");
        }
    }

    /*=============================================================== Funções Update ==================================================================*/
    public void alterarDados() {
        cliente = new Cliente();
        comando = "Alterar";
        JOptionPane.showMessageDialog(null, " Alterando cliente");
        habilitarCampos();
        sair.setEnabled(false);
        inserir.setEnabled(false);
        alterar.setEnabled(false);
        remover.setEnabled(false);
        cancelar.setEnabled(true);
        confirmar.setEnabled(true);
    }

    public void alterarSQL() {
        boolean isValid = validarFormulario();
        if (isValid == true) {
            cliente.id = Integer.parseInt(t1.getText());
            cliente.nome = t2.getText();
            cliente.tel_Residencial = t3.getText();
            cliente.tel_Comercial = t4.getText();
            cliente.tel_Celular = t5.getText();
            cliente.email = t6.getText();
            try {
                ComandoSQL sql = new ComandoSQL();
                sql.update(cliente);
                JOptionPane.showMessageDialog(null, " Alterado com sucesso.");
                limparCamposFormulario();
                desabilitarBotoes();
                desabilitarCampos();
                preencherTabela();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, " Falha ao alterar cliente.");
            }

        } else {
            JOptionPane.showMessageDialog(null, " Preencha o formulario corretamente");
        }
    }

    /*=============================================================== Funções Delete ==================================================================*/
    public void removerDados() {
        comando = "Remover";
        JOptionPane.showMessageDialog(null, " Para remover este cliente clique no botão 'Confirmar'.");
        sair.setEnabled(false);
        inserir.setEnabled(false);
        alterar.setEnabled(false);
        remover.setEnabled(false);
        confirmar.setEnabled(true);
        cancelar.setEnabled(true);

    }

    public void removerSQL() {
        try {
            ComandoSQL sql = new ComandoSQL();
            int id = Integer.parseInt(t1.getText());
            sql.deletar(id);
            JOptionPane.showMessageDialog(null, " Deletado com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Falha ao deletar.");
        }
        limparCamposFormulario();
        desabilitarBotoes();
        desabilitarCampos();
        preencherTabela();
    }

    /*=============================================================== Funções Confirmar ===============================================================*/
    public void confirmarDados() {
        //JOptionPane.showMessageDialog(null, " Processando confirmação dos dados");
        switch (comando) {
            case "Inserir":
                inserirSQL();
                break;
            case "Remover":
                int codigo = JOptionPane.showConfirmDialog(null, "Deseja remover este cliente?", "Remover", JOptionPane.YES_NO_OPTION);
                if (codigo == JOptionPane.YES_OPTION) {
                    removerSQL();
                }
                break;
            case "Alterar":
                alterarSQL();
                break;
            case "Cancelar":
                cancelarDados();
                break;
            case "Fechar":
                fecharCadastro();
                break;
        }
    }

    /*=============================================================== Funções Cancelar ================================================================*/
    public void cancelarDados() {
        comando = "Cancelar";
        int codigo = JOptionPane.showConfirmDialog(null, "Deseja cancelar essa operação?", "Cancelar", JOptionPane.YES_NO_OPTION);
        if (codigo == JOptionPane.YES_OPTION) {
            limparCamposFormulario();
            desabilitarCampos();
            desabilitarBotoes();
        } else {

        }
    }

    /*=============================================================== Funções Sair ====================================================================*/
    public void fecharCadastro() {
        comando = "Fechar";
        int codigo = JOptionPane.showConfirmDialog(null, "Deseja Sair?", "LogOff", JOptionPane.YES_NO_OPTION);
        if (codigo == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }
}
