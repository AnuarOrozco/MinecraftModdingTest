package com.anuar.randomstuff.common.items;

import com.anuar.randomstuff.RandomStuffMain;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Food {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RandomStuffMain.MODID);

    public static final RegistryObject<Item> TACO = ITEMS.register("taco",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build())));

    public static final RegistryObject<Item> BURRITO_SUPREMO = ITEMS.register("burrito_supremo",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1.2F).build())));

    public static final RegistryObject<Item> HANZEEL = ITEMS.register("hanzeel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(10)  // Gran cantidad de nutrición
                    .saturationMod(1.5F)  // Alta saturación
                    .alwaysEat()  // Se puede comer incluso con la barra de hambre llena
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 1.0F)  // Da confusión por un rato
                    .effect(() -> new MobEffectInstance(MobEffects.LUCK, 600, 0), 1.0F)  // También da suerte por un tiempo
                    .build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

