package UI;

import dados.RepositorioSessoes;
import fachada.FachadaGerente;
import negocio.Exceptions.*;
import negocio.entidades.*;

import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TelaCadastroSessoes {
    private Scanner scanner;
    private FachadaGerente fachada;

    public TelaCadastroSessoes(FachadaGerente fachada){
        this.scanner = new Scanner(System.in);
        this.fachada = fachada;
    }

    public void iniciar(){
        System.out.println("Tela Cadastro Sessoes");

        while (true){
            System.out.println("1 - Adicionar Sessao");
            System.out.println("2 - Remover Sessao");
            System.out.println("3 - Atualizar Sessao");
            System.out.println("4 - Buscar Sessoes por titulo de Filme");
            System.out.println("5 - Listar Sessoes do dia");
            System.out.println("6 - Listar Todas as Sessoes");
            System.out.println("7 - Voltar");

            Sessao sessao;
            Filme filme = null;
            String titulo,codigo,horario,dia;
            Sala sala = null;

            int opcao = -1;

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("Digite um número");
                scanner.nextLine();
                continue;
            }

            switch (opcao){
                case 1:
                    adicionarSessao();
                    break;
                case 2:
                    removerSessao();
                    break;
                case 3:
                    atualizarSessoes();
                    break;
                case 4:
                    buscarSessaoporTitulo();
                    break;
                case 5:
                    buscarSessaoDia();
                    break;
                case 6:
                    imprimeTodasSessoes();
                    break;
                case 7:
                    return;

                default:
                    System.out.println("Opção Invalida");

            }
        }
    }
    private void adicionarSessao(){
        System.out.println("Filme");
        String titulo = scanner.nextLine();

        Filme filme =null;
        Sala sala=null;
        Sessao sessao;

        try {
            filme = fachada.procurarFilme(titulo);
        } catch (FilmeNaoEstaNoCatalogoException e) {
            System.err.println(e);
            return;
        }

        System.out.println("Horario (hh:mm)");
        String horario = scanner.nextLine();
        LocalTime horarios;

        try{
            horarios = LocalTime.parse(horario);
        }catch (DateTimeParseException e){
            System.err.println("Formatação errada, use hh:mm");;
            return;
        }


        System.out.println("Codigo da Sala");
        String codigo = scanner.nextLine();


        try {
            sala = fachada.procuraSala(codigo);
        } catch (SalaNaoEncontradaException e) {
            System.err.println(e);
            return;
        }


        System.out.println("dia");
        String dia = scanner.nextLine();


        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
            MonthDay mddia = MonthDay.parse(dia, formatter);
            sessao = new Sessao(filme, horario, sala, dia);

            fachada.adicionarSessao(sessao);
        } catch (DateTimeParseException e) {
            System.err.println("Erro: Formato de data inválido. Use dd-MM.");
        } catch (SessaojaExisteException e) {
            System.err.println("Erro: Essa sessão já existe.");
        }
    }
    private void removerSessao(){

        String horario,codigo,dia;
        Sala sala = null;

        System.out.println("Horario da sessao");
        horario = scanner.nextLine();
        LocalTime horarios;
        try{
            horarios = LocalTime.parse(horario);
        }catch (DateTimeParseException e){
            System.err.println("Formatação errada, use hh:mm");;
            return;
        }

        System.out.println("Codigo da sala");
        codigo = scanner.nextLine();
        try {
            sala = fachada.procuraSala(codigo);
        } catch (SalaNaoEncontradaException e) {
            System.err.println("Sala nao encontrada");
            return;
        }


        System.out.println("Dia");
        dia = scanner.nextLine();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
            MonthDay mddia = MonthDay.parse(dia, formatter);
            fachada.removerSessao(horario,codigo, dia);
        } catch (SessaoNaoEncontradaException e) {
            System.err.println(e);;
        }catch (DateTimeParseException e){
            System.out.println("Erro: Formato de data inválido. Use dd-MM.");
        }
    }
    private void atualizarSessoes(){
        System.out.println("Filme");
        String titulo = scanner.nextLine();
        Filme filme =null;
        Sala sala=null;
        Sessao sessao;

        try {
            filme = fachada.procurarFilme(titulo);
        } catch (FilmeNaoEstaNoCatalogoException e) {
            System.err.println("Filme nao esta no catalogo");
        }

        System.out.println("Horario");
        String horario = scanner.nextLine();
        LocalTime horarios;
        try{
            horarios = LocalTime.parse(horario);
        }catch (DateTimeParseException e){
            System.err.println("Formatação errada, use hh:mm");;
            return;
        }

        System.out.println("Codigo da Sala");
        String codigo = scanner.nextLine();
        try {
            sala = fachada.procuraSala(codigo);
        } catch (SalaNaoEncontradaException e) {
            System.err.println(e);
        }
        System.out.println("dia");
        String dia = scanner.nextLine();

        sessao = new Sessao(filme,horario,sala,dia);

        try {
            fachada.atualizarSessao(sessao);
        } catch (SessaoNaoEncontradaException e) {
            System.err.println(e);
        }
    }
    private void buscarSessaoporTitulo(){
        String titulo = scanner.nextLine();
        ArrayList<Sessao> dias = new ArrayList<>();
        try {
            dias = fachada.procurarSessaoTitulo(titulo);
        } catch (SessaoNaoEncontradaException e) {
            System.err.println("Sessao nao encontrada");
        }
        for (Sessao s : dias){
            System.out.println(s);
        }

    } private void buscarSessaoDia(){
        String dia = scanner.nextLine();
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
            MonthDay mddia = MonthDay.parse(dia,formatter);
        }catch (DateTimeParseException e){
            System.err.println("Formato invalido");
        }
        ArrayList<Sessao> dias = new ArrayList<>();
        try {
            dias = fachada.procurarSessaoporDia(dia);
        } catch (SessaoNaoEncontradaException e) {
            throw new RuntimeException(e);
        }
        for (Sessao s : dias){
            System.out.println(s);
        }
    }
    private void imprimeTodasSessoes(){
        ArrayList<Sessao> s = fachada.imprimirSessoes();
        for (Sessao sessao : s) {
            System.out.println(sessao);
        }
    }
}