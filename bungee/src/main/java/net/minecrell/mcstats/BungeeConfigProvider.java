/*
 * Copyright (c) 2016, Minecrell <https://github.com/Minecrell>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.minecrell.mcstats;

import net.md_5.bungee.api.ProxyServer;

/**
 * A simple {@link StatsLite.ConfigProvider} for BungeeCord that uses
 * the properties defined in the BungeeCord configuration.
 */
final class BungeeConfigProvider implements StatsLite.ConfigProvider {

    static final BungeeConfigProvider INSTANCE = new BungeeConfigProvider();

    private String uniqueId;

    private BungeeConfigProvider() {
    }

    @Override
    public void reload() {
        this.uniqueId = ProxyServer.getInstance().getConfig().getUuid();
    }

    @Override
    public boolean isOptOut() {
        return this.uniqueId == null || this.uniqueId.isEmpty() || this.uniqueId.equalsIgnoreCase("null");
    }

    @Override
    public String getUniqueId() {
        return this.uniqueId;
    }

}