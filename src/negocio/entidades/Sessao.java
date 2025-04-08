package negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Sessao implements Serializable {
    @Serial
    private static final long serialVersionUID = -5907168795004785658L;
    private LocalTime horario;
    private Filme filme;
    private Sala sala;

    public Sessao(Filme filme, String horario,Sala sala){
        this.filme = filme;
        this.horario = LocalTime.parse(horario);
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "negocio.entidades.Sessao{" +
                "horario=" + horario +
                ", filme=" + filme +
                ", sala=" + sala
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sessao sessao = (Sessao) o;
        return Objects.equals(horario, sessao.horario) && Objects.equals(sala, sessao.sala);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horario, sala);
    }
}
