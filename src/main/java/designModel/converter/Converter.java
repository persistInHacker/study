package designModel.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/26 9:52
 * @since JDK1.8
 */
public class Converter <P ,K>{

    private Function<P,K> fromDto;
    private Function<K,P> fromEntity;

    public Converter(Function<P, K> fromDto, Function<K, P> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final K convertFromDto(final P p){
        return fromDto.apply(p);
    }

    public final P convertFromEntity(final K k){
        return fromEntity.apply(k);
    }

    public List<K> convertFromDtos(Collection<P> collectors) {
        return collectors.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    public List<P> convertFromEntities(Collection<K> collectors) {
        return collectors.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}
