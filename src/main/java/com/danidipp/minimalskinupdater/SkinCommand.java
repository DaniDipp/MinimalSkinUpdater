package com.danidipp.minimalskinupdater;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SkinCommand extends Command {

	List<URL> urls = new ArrayList<>();

	protected SkinCommand() {
		super("skin");

		try {
			urls.add(new URL(
					"http://textures.minecraft.net/texture/e2629257181ff3dc2a398da5b8595ca21956cfa8b93b4bc9170d7e61e867a00a")); //Luigi
			urls.add(new URL(
					"http://textures.minecraft.net/texture/a47cd422d14c88e0479e35eb9ed718be83b9b2d3ba61992262bb97a83715ed06")); //Mario
			urls.add(new URL(
					"http://textures.minecraft.net/texture/542952e6434db9ae791d19ee95be32982f30d20cf7ca819b879fe32792d290fa")); //Peach
			urls.add(new URL(
					"http://textures.minecraft.net/texture/12b5f123739bc47635e73c3643d630c0db39988badb85ec5133827eb3c4bd424")); //Yoshi
			urls.add(new URL(
					"http://textures.minecraft.net/texture/2cbf0187c3058829e3b10706bad8e77a74b522666cb7e85d838f16e30d642065")); //Bowser
		} catch (MalformedURLException e) {
			throw new IllegalStateException();
		}
	}

	URL getNewSkin(URL current) {
		Collections.shuffle(urls);
		return urls.stream()
				.filter(url -> !url.getPath().equals(current.getPath())) // Setting the same skin results in Alex for some reason.
				.findFirst().get();
	}

	@Override
	public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
		if (!(sender instanceof Player))
			return false;
		var player = (Player) sender;

		var profile = player.getPlayerProfile();
		var textures = profile.getTextures();
		var newSkin = getNewSkin(textures.getSkin());
		textures.setSkin(newSkin);
		profile.setTextures(textures);
		player.setPlayerProfile(profile);

		player.sendMessage("Updated skin: " + newSkin.getPath().split("/")[2]);
		return true;
	}

}
