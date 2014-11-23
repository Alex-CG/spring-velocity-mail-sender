package base.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFromBeanUtil {

  private static Map<String, Object> map;

  public static Map<String, Object> convertir(Object obj) {
    if (obj == null) {
      return null;
    }
    try {
      map = new HashMap<String, Object>();
      return parsear(obj);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return null;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      return null;
    }
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static Map<String, Object> parsear(Object obj) throws IllegalArgumentException,
      IllegalAccessException {

    // Se iteran todos los campos
    for (Field field : obj.getClass().getDeclaredFields()) {
      field.setAccessible(true);

      // Si el tipo no es una lista entonces se agrega al mapa de retorno
      if (field.getType() != List.class) {
        map.put(field.getName(), field.get(obj));
      } else {

        List<?> someList = (List<?>) field.get(obj);

        ArrayList listSubMaps = new ArrayList<>();

        if (someList != null) {

          // Se iteran los items de la lista
          for (Object item : someList) {

            Map<String, Object> subMap = new HashMap<>();

            // Se iteran los campos de los items
            for (Field fielItem : item.getClass().getDeclaredFields()) {
              fielItem.setAccessible(true);
              // Se guardan los valores de los campos
              subMap.put(fielItem.getName(), fielItem.get(item));
            }

            // Se agregan los mapas de los items a la lista
            listSubMaps.add(subMap);
          }
        }

        // Se agrega la Lista a el mapa de retorno
        map.put(field.getName(), listSubMaps);

      }

    }
    return map;
  }

}
